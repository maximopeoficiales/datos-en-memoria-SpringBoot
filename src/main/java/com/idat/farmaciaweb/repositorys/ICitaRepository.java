package com.idat.farmaciaweb.repositorys;

import com.idat.farmaciaweb.models.Cita;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Se pone @Repository para que sea reconocido Por Spring Boot 
@Repository
public interface ICitaRepository extends JpaRepository<Cita, Integer> {
    // Esta interface sera implementada en la su clase de Servicio
    // JpaRepository gracias a JPA podemos entender de el y obtener los metodos CRUD
    // como tambien customizarlos a nuestros gusto

}