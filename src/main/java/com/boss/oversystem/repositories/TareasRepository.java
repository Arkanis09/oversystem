package com.boss.oversystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.boss.oversystem.entities.Tareas;

@Repository
public interface TareasRepository extends JpaRepository<Tareas, Integer> {

}
