package com.idat.farmaciaweb.services;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import com.idat.farmaciaweb.models.Medicamento;
import com.idat.farmaciaweb.repositorys.MedicamentoRepository;

import org.springframework.stereotype.Service;

@Service
public class MedicamentoService implements MedicamentoRepository {

    @Override
    public List<Medicamento> getMedicamentos() {
        List<Medicamento> listMedicamentos = new ArrayList<Medicamento>();
        listMedicamentos.add(new Medicamento(1, "Lorem", "Lorem", "M", LocalDate.of(2025, Month.MAY, 12)));
        listMedicamentos.add(new Medicamento(2, "Lorem", "Lorem", "M", LocalDate.of(2021, Month.FEBRUARY, 22)));
        listMedicamentos.add(new Medicamento(3, "Lorem", "Lorem", "F", LocalDate.of(2023, Month.MAY, 23)));
        return listMedicamentos;
    }

    @Override
    public List<Medicamento> agregarMedicamento(Medicamento medicamento) {
        List<Medicamento> listMedicamentos = this.getMedicamentos();
        medicamento.setIdMedicamento(listMedicamentos.size() + 1);
        listMedicamentos.add(medicamento);
        return listMedicamentos;
    }

}
