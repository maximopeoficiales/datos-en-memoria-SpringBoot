package com.idat.farmaciaweb.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Paciente {
    private int idPaciente;
    private String nombre;
    private String apellido;
    private String sexo;
    private String email;
    // private LocalDate fechaNacimiento;
    private int edad;
}
