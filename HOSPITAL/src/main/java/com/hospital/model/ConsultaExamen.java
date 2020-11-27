package com.hospital.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@IdClass(ConsultaExamenPK.class)
@Table(name = "tbl_consulta_examen")
public class ConsultaExamen {

    // [idConsulta(FK) idExamen(FK)] PK
    @Id
    private Consulta consulta;

    @Id
    private Examen examen;

}
