package com.hospital.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="tbl_examen")
public class Examen {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer idExamen;

    @Column(name="nombre", nullable=false, length=50)
    private String nombre;


    @Column(name="descripcion", nullable=false, length=50)
    private String descripcion;

}
