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
@IdClass(UsuarioRolPK.class)
@Table(name = "tbl_usuario_rol")
public class UsuarioRol {

    // [idUsuario(FK) idRol(FK)] PK
    @Id
    private Usuario usuario;

    @Id
    private Rol rol;

}
