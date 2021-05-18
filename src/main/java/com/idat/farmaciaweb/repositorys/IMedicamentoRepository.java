package com.idat.farmaciaweb.repositorys;

import com.idat.farmaciaweb.models.Medicamento;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface IMedicamentoRepository extends JpaRepository<Medicamento, Integer> {

}
