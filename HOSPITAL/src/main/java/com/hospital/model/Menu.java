package com.hospital.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "tbl_menu")
public class Menu {

    @Id
    private Integer idMenu;

    @Column(name = "icono", length = 20)
    private String icono;

    @Column(name = "nombre", length = 20)
    private String nombre;

    @Column(name = "url", length = 50)
    private String url;

}
