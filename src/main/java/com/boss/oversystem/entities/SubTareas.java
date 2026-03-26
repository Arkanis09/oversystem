package com.boss.oversystem.entities;

import javax.persistence.*;

@Entity
@Table(name = "SUB_TAREAS")
public class SubTareas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long Id;

    @Column(name = "NOMBRE")
    private String Nombre;

    @Column(name = "DESCRIPCION")
    private String Descripcion;

    @ManyToOne
    @JoinColumn(name = "TAREAS_ID")
    private Tareas Tareas;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

    public Tareas getTareas() {
        return Tareas;
    }

    public void setTareas(Tareas tareas) {
        Tareas = tareas;
    }

}
