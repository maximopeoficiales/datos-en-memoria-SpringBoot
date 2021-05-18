package com.idat.farmaciaweb.models;

// import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// de aqui
@NoArgsConstructor
@AllArgsConstructor
@Data
// hasta aqui puedes reemplarlo con el get and set , construtor , contructor
// vacio
@Entity
@Table(name = "citas")
public class Cita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int idCita;

    private String descripcion;

    private String fecha;

    @Column(name = "id_paciente")
    private Integer idPaciente;

    @ManyToOne
    @JoinColumn(name = "id_paciente", insertable = false, updatable = false)
    private Paciente paciente;
}
