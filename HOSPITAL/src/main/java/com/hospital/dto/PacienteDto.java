package com.hospital.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class PacienteDto {

    private Integer idPaciente;

    private String nombres;
    private String apellidos;
    private String dni;
    private String direccion;
    private String telefono;
    private String email;
    private MultipartFile imgUrl;
}
