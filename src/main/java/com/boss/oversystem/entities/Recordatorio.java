package com.boss.oversystem.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "RECORDATORIO")
public class Recordatorio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer Id;

    @JoinColumn(name = "TAREAS_ID")
    @ManyToOne
    private Tareas Tareas;

    @JoinColumn(name = "USER_ID")
    @ManyToOne
    private Usuario Usuario;

    @Column(name = "FECHA_INICIO")
    private Date FechaInicio;

    @Column(name = "FECHA_FIN")
    private Date FechaFin;

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

    public Usuario getUsuario() {
        return Usuario;
    }

    public void setUsuario(Usuario usuario) {
        Usuario = usuario;
    }

    public Date getFechaInicio() {
        return FechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        FechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return FechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        FechaFin = fechaFin;
    }

}
