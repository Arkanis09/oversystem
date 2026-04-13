package com.boss.oversystem.services;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.boss.oversystem.entities.Categorias;
import com.boss.oversystem.repositories.CategoriasRepository;

@Service
public class CategoriasService {

    private final CategoriasRepository categoriasRepository;

    public CategoriasService(CategoriasRepository categoriasRepository) {
        this.categoriasRepository = categoriasRepository;

    }

    public List<Categorias> leer() {

        return categoriasRepository.findAll();

    }

    public Categorias guardar(Categorias categorias) {

        return categoriasRepository.save(categorias);
    }

    @Transactional
    public Categorias actualizar(Integer id, Categorias categorias) {
        Categorias categoria = categoriasRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Categoría no encontrada"));

        if (categorias.getNombre() == null || categorias.getNombre().trim().isEmpty()
                || categorias.getNombre().equals(categoria.getNombre())) {
            throw new IllegalArgumentException("No debe dejar en blanco el nombre o poner el mismo si va a actualizar");

        }
        // Nota mental: para poder hacer una sobreescritura debes llamar el set... ahí
        // es donde recibirá el parámetro
        // de ahí le meter un get... que es lo que obtenemos en el sistema...
        categoria.setNombre(categorias.getNombre());

        return categoria;

    }

    public void eliminarCategoria(Integer id) {
        if (!categoriasRepository.existsById(id)) {
            // Los throw new illegal pueden usarse facilmente sin concatenarlo en alguna
            // parte
            throw new IllegalArgumentException("La categoría no existe");
        }
        categoriasRepository.deleteById(id);
    }

}