package com.hospital.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Data
@Entity
@Table(name = "consulta")
public class Consulta {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idConsulta;
    //Clase que representa llave foranea
    //toda FK es ManyToOne

    @Column(name = "num_consultorio", length = 3, nullable = true)
    private String numConsultorio;

    @Column(name = "fecha", nullable = true)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fecha;



    //----------------------------------------------------------------------------
    @ManyToOne
    @JoinColumn(name="id_paciente", nullable=false, foreignKey= @ForeignKey(name="FK_consulta_paciente"))
    private Paciente paciente;

    @ManyToOne
    @JoinColumn(name="id_medico", nullable=false, foreignKey=@ForeignKey(name="FK_consulta_medico"))
    private Medico medico;

    @ManyToOne
    @JoinColumn(name="id_especialidad", nullable=false, foreignKey=@ForeignKey(name="fk_consulta_especialidad"))
    private Especialidad especialidad;



//    @OneToMany (mappedBy = "consulta", cascade = {CascadeType.ALL}, orphanRemoval = true)
//    private List<DetalleConsulta> detalleConsulta;




}
