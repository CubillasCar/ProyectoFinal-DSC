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
public class UsuarioRolPK implements Serializable {

    @ManyToOne
    @JoinColumn(name="id_usuario", nullable = false, foreignKey=@ForeignKey(name="FK_UsuarioRol_usuario"))
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name="id_rol", nullable = false, foreignKey=@ForeignKey(name="FK_UsuarioRol_rol"))
    private Rol rol;
}
