package com.idat.farmaciaweb.models;

import java.time.LocalDate;
// import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Cita {
    private int idCita;
    private String descripcion;
    private LocalDate fecha;
    private Paciente paciente;
}
