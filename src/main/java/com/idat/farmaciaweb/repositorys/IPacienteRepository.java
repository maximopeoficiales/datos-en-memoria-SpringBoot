package com.idat.farmaciaweb.repositorys;

import com.idat.farmaciaweb.models.Paciente;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface IPacienteRepository extends JpaRepository<Paciente, Integer>{

}
