package com.idat.farmaciaweb.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class MedicamentoPrecio {
    private String nombre;
    private Double precio;
    private int cantidad;
}
