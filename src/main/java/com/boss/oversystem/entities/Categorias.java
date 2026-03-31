package com.boss.oversystem.entities;

import javax.persistence.*;


@Entity
@Table(name = "CATEGORIAS")
public class Categorias {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer Id;

    @Column(name = "NOMBRE")
    private String Nombre;

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

}
