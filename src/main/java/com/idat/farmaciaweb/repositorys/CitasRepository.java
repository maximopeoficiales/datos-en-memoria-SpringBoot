package com.idat.farmaciaweb.repositorys;

import java.util.List;

import com.idat.farmaciaweb.models.Cita;

public interface CitasRepository {
    List<Cita> getCitas();

    List<Cita> agregarCita(Cita cita);

}
