package com.boss.oversystem.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boss.oversystem.entities.Categorias;
import com.boss.oversystem.exception.CategoriaDuplicadaException;
import com.boss.oversystem.exception.CrudExceptions;
import com.boss.oversystem.repositories.CategoriasRepository;

@Service
public class CategoriasService {

    @Autowired
    private CategoriasRepository categoriasRepository;

    public Categorias Guardar(Categorias categorias) {

        categoriasRepository.findById(categorias.getId())
                .ifPresent(categoria -> {
                    throw new CrudExceptions("ya hay una categoria con este id: " + categorias.getId());
                });

        return categoriasRepository.save(categorias);
    }

    /*
     * public Categorias Actualizar(Integer id, Categorias categorias) {
     * 
     * }
     */

}
