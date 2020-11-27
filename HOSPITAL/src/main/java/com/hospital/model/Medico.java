package com.hospital.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="medico")
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMedico;


    @Column(name = "nombres", nullable = false, length = 70)
    private String nombres;


    @Column(name = "apellidos", nullable = false, length = 70)
    private String apellidos;


    @Column(name = "CMP", nullable = false, length = 12)
    private String CMP;


    @Column(name = "foto_url", nullable = true)
    private String fotoUrl;

    private String imgUrl;
    private String key;

    public Medico(String nombres, String apellidos, String CMP, String fotoUrl, String imgUrl, String key) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.CMP = CMP;
        this.fotoUrl = fotoUrl;
        this.imgUrl = imgUrl;
        this.key = key;
    }
}
