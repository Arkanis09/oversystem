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
@Table(name = "COMENTARIOS")
public class Comentarios {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer Id;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private Usuario Usuario;

    @ManyToOne
    @JoinColumn(name = "TAREAS_ID")
    private Tareas Tareas;

    @Column(name = "DESCRIPCION")
    private String Descripcion;

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public Usuario getUsuario() {
        return Usuario;
    }

    public void setUsuario(Usuario usuario) {
        Usuario = usuario;
    }

    public Tareas getTareas() {
        return Tareas;
    }

    public void setTareas(Tareas tareas) {
        Tareas = tareas;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

}
