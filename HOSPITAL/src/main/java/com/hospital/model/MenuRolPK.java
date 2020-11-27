package com.hospital.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode
@Embeddable
public class MenuRolPK implements Serializable {



    @ManyToOne
    @JoinColumn(name = "id_menu", nullable = false, foreignKey=@ForeignKey(name="FK_MenuRol_menu"))
    private Menu menu;

    @ManyToOne
    @JoinColumn(name = "id_rol", nullable = false, foreignKey=@ForeignKey(name="FK_MenuRol_rol"))
    private Rol rol;
}
