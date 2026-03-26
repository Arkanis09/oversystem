package com.boss.oversystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.boss.oversystem.entities.Categorias;

@Repository
public interface CategoriasRepository extends JpaRepository<Categorias, Long> {

}
