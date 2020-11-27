package com.hospital.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="tbl_detalle_consulta")
public class DetalleConsulta {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer IdDetalle;

    @ManyToOne
    @JoinColumn(name="id_consulta", nullable=false, foreignKey=@ForeignKey(name="FK_consulta_detalle"))
    private Consulta consulta;

    @Column(name="diagnostico", nullable=false)
    private String diagnostico;

    @Column(name="tratamiento", nullable=false)
    private String tratamiento;

}

