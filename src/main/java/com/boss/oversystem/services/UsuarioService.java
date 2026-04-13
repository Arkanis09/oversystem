package com.boss.oversystem.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.boss.oversystem.entities.Usuario;
import com.boss.oversystem.repositories.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepo;

    @Autowired
    private PasswordEncoder PEncoder;

    public Usuario guardarUsuario(Usuario user) {
        usuarioRepo.findByUsername(user.getUsername())
                .ifPresent(usuario -> {
                    throw new IllegalArgumentException("Este nombre de usuario ya está en uso");
                });

        // para poder ponerle encriptado a la contraseña, es necesario sacarla cuando
        // venga y después volver a ponerla
        // encriptada llamando al método que encripta para que funcione
        user.setPassword(PEncoder.encode(user.getPassword()));

        return usuarioRepo.save(user);
    }

}
