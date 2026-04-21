package com.boss.oversystem.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boss.oversystem.entities.Categorias;
import com.boss.oversystem.services.CategoriasService;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private CategoriasService categoryService;

    /*
     * para apis y restcontrollers o restfull apis para no tener disparidad o
     * errores
     * es necesario poner en el método el response entity y poner lo que necesita,
     * en este caso en listado la categoría
     */
    @GetMapping("/show")
    public ResponseEntity<List<Categorias>> ShowCategory(Model model) {

        List<Categorias> categories = categoryService.showCategory();

        model.addAttribute("categories", categories);
        model.addAttribute("titulo", "Categorías");

        return ResponseEntity.ok(categories);

    }

}
