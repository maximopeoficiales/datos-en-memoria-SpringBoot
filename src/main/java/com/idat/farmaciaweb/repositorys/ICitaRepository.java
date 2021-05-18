package com.idat.farmaciaweb.repositorys;

import com.idat.farmaciaweb.models.Cita;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICitaRepository extends JpaRepository<Cita,Integer>{
    
}
