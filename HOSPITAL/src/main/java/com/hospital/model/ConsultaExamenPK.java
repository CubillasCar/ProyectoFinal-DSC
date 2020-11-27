package com.hospital.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Embeddable;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;


@Data
@EqualsAndHashCode
@Embeddable
public class ConsultaExamenPK implements Serializable {


//clases que se van a convertir en objetos
    @ManyToOne
    @JoinColumn(name = "id_consulta", nullable = false, foreignKey=@ForeignKey(name="FK_ConsultaExamen_consulta"))
    private Consulta consulta;

    @ManyToOne
    @JoinColumn(name = "id_examen", nullable = false, foreignKey=@ForeignKey(name="FK_ConsultaExamen_examen"))
    private Examen examen;


}
