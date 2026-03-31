package com.boss.oversystem.entities;

import javax.persistence.*;

import com.boss.oversystem.enums.Prioridad;
import com.boss.oversystem.enums.Status;;

@Entity
@Table(name = "TAREAS")
public class Tareas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer Id;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private Usuario Usuario;

    @Column(name = "TITULO")
    private String Titulo;

    @Column(name = "DESCRIPCION")
    private String Descripcion;

 @Enumerated(EnumType.STRING)
@Column(name = "STATUS", length = 20)
private Status Status;

@Enumerated(EnumType.STRING)
@Column(name = "PRIORIDAD", length = 20)
private Prioridad prioridad;

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

    public String getTitulo() {
        return Titulo;
    }

    public void setTitulo(String titulo) {
        Titulo = titulo;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

    public Status getStatus() {
        return Status;
    }

    public void setStatus(Status status) {
        Status = status;
    }



}
