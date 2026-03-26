package com.boss.oversystem.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.boss.oversystem.entities.Usuario;
import com.boss.oversystem.services.UsuarioService;

@Controller
@RequestMapping("/authentication")
public class LoginController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/login")
    public String Login() {
        return "login";
    }

    @GetMapping("/register")
    public String RegisterPage() {
        return "register";
    }

    @PostMapping("/register")
    public String Register(@ModelAttribute Usuario usuario) {

        usuarioService.GuardarUsuario(usuario);

        return "redirect:/login";
    }

}
