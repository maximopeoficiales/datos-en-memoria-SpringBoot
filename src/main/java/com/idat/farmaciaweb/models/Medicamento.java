package com.idat.farmaciaweb.models;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "medicamentos") //especifica como se llamara en la base de datos
public class Medicamento {
    // indica que es el id y que sera autoincrementable
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int idMedicamento;
    
    private String nombre;
    private String nombreComercial;
    private String nombreLaboratorio;
    private String fechaVencimiento;

}
