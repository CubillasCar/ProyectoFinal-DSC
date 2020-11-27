package com.hospital.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class MedicoDto {

    private Integer idMedico;
    private String nombres;
    private String apellidos;
    private String CMP;
    private String fotoUrl;
    private String imgUrl;
}
