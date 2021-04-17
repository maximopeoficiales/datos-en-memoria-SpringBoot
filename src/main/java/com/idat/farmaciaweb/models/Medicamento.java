package com.idat.farmaciaweb.models;

import java.time.LocalDate;
// import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Medicamento {
    private int idMedicamento;
    private String nombre;
    private String nombreComercial;
    private String nombreLaboratorio;
    private LocalDate fechaVencimiento;

}
