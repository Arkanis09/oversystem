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

    // Método crear

    public Usuario GuardarUsuario(Usuario user) {
        usuarioRepo.findByUsername(user.getUsername())
                .ifPresent(usuario -> {
                    throw new IllegalArgumentException("Este nombre de usuario ya está en uso");
                });

        user.setPassword(PEncoder.encode(user.getPassword()));

        return usuarioRepo.save(user);
    }

}
