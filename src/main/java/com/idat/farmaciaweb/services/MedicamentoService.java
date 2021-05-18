package com.idat.farmaciaweb.services;

import java.util.List;
import java.util.Optional;

import com.idat.farmaciaweb.models.Medicamento;
import com.idat.farmaciaweb.repositorys.IMedicamentoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MedicamentoService {
    @Autowired
    private IMedicamentoRepository crud;

    public List<Medicamento> getMedicamentos() {
        return (List<Medicamento>) crud.findAll();
    }

    public Optional<Medicamento> getMedicamento(int idMedicamento) {
        return crud.findById(idMedicamento);
    }

    public Medicamento save(Medicamento medicamento) {
        return crud.save(medicamento);
    }

    public void delete(int idMedicamento) {
        crud.deleteById(idMedicamento);
    }
}
