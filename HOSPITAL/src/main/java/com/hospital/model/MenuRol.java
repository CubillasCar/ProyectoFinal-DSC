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
@IdClass(MenuRolPK.class)
@Table(name="tbl_menu_rol")
public class MenuRol {

    // [idMenu(FK) idRol(FK)] PK
    @Id
    private Menu menu;

    @Id
    private Rol rol;
}
