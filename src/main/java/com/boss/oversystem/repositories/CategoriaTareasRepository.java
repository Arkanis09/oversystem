package com.boss.oversystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.boss.oversystem.entities.CategoriaTareas;

@Repository
public interface CategoriaTareasRepository extends JpaRepository<CategoriaTareas, Long> {

}
