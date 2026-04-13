package com.boss.oversystem.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    public String Login(HttpSession session, Model model) {

        return "login";
    }

    @GetMapping("/register")
    public String RegisterPage(Model model) {
        model.addAttribute("user", new Usuario());
        return "register";
    }

    @PostMapping("/register")
    public String Register(@ModelAttribute Usuario usuario, Model model) {

        try {
            usuarioService.guardarUsuario(usuario);
        } catch (IllegalArgumentException e) {

            model.addAttribute("UserErrorExists", e.getMessage());
            return "register";

        } catch (Exception ex) {

            model.addAttribute("UserErrorExists", "Error al registrar usuario");
            return "register";

        }

        return "redirect:/authentication/login";
    }

}
