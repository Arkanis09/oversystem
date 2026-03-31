package com.boss.oversystem.entities;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "USUARIOS")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Integer Id;

    @NotBlank(message = "El nombre es obligatorio")
    @Column(name = "USERNAME", nullable = false, length = 100)
    private String username;

    @NotBlank(message = "la contraseña es obligatoria")
    @Column(name = "PASSWORD", nullable = false)
    private String password;

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
