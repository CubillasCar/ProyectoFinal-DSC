package com.hospital.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "paciente")
public class Paciente {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String idPaciente;

    @Column(name = "nombres", nullable = false, length = 70)
    private String nombres;


    @Column(name = "apellidos", nullable = false, length = 70)
    private String apellidos;


    @Column(name = "dni", nullable = false, length = 8)
    private String dni;



    @Column(name = "direccion", nullable = false, length = 70)
    private String direccion;



    @Column(name = "telefono", nullable = false, length = 9)
    private String telefono;


    @Column(name = "email", nullable = false, length = 70)
    private String email;

    private String imgUrl;
    private String key;

    public Paciente(String nombres, String apellidos, String dni, String direccion, String telefono, String email, String imgUrl, String key) {

        this.nombres = nombres;
        this.apellidos = apellidos;
        this.dni = dni;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
        this.imgUrl = imgUrl;
        this.key = key;
    }
}
