package com.boss.oversystem.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "CATEGORIA_TAREAS")
public class CategoriaTareas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer Id;

    @ManyToOne
    @JoinColumn(name = "TAREAS_ID")
    private Tareas Tareas;

    @ManyToOne
    @JoinColumn(name = "CATEGORIAS_ID")
    private Categorias Categorias;

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public Tareas getTareas() {
        return Tareas;
    }

    public void setTareas(Tareas tareas) {
        Tareas = tareas;
    }

    public Categorias getCategorias() {
        return Categorias;
    }

    public void setCategorias(Categorias categorias) {
        Categorias = categorias;
    }



}
