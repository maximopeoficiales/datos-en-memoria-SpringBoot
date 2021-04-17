package com.idat.farmaciaweb.repositorys;

import java.util.List;

import com.idat.farmaciaweb.models.Medicamento;

public interface MedicamentoRepository {
    List<Medicamento> getMedicamentos();

    List<Medicamento> agregarMedicamento(Medicamento medicamento);

}
