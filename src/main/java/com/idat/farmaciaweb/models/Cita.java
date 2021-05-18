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
// @Entity identifa nuestra clase como entidad en la BD
@Entity
@Table(name = "citas") // @Table nombra la tabla en la BD
public class Cita {
    // @id indica que sera el primary key
    // @GeneratedValue le indica la estrategia del primary key, en este caso es
    // identity
    // @Column nombra la propiedad en la BD
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int idCita;

    private String descripcion;

    private String fecha;

    @Column(name = "id_paciente")
    private Integer idPaciente;

    // Muchas Citas puede tener un Paciente
    // @ManyToOne indica la relacion de uno a muchos
    // @JoinColumn indica la propiedad de la tabla cita se le relacionara con
    // Paciente osea con su id, se le indica que la propiedad paciente no sera
    // insertada ni actualizada
    @ManyToOne
    @JoinColumn(name = "id_paciente", insertable = false, updatable = false)
    private Paciente paciente;
}
