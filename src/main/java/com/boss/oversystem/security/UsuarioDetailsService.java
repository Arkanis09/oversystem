package com.boss.oversystem.security;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.boss.oversystem.entities.Usuario;
import com.boss.oversystem.repositories.UsuarioRepository;

@Service
public class UsuarioDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioDetailsService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario Usuario = usuarioRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario No encontrado" + username));

        return User.withUsername(Usuario.getUsername())
                .password(Usuario.getPassword())
                .roles("USER")// detalle importante... si vas a hacer esto de usar spring security...
                // tienes que poner obligatoriamente el rol.... sino te dará error al loguearte
                // y los logs no te dirán mucho
                .build();
    }

}
