package com.boss.oversystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.boss.oversystem.entities.Recordatorio;

@Repository
public interface RecordatorioRepository extends JpaRepository<Recordatorio, Long> {

}
