package com.clinicasonrisas.clinica.repository;

import com.clinicasonrisas.clinica.model.Cita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface CitaRepository extends JpaRepository<Cita, Long> {
    List<Cita> findByDentistaIdAndFechaHora(Long dentistaId, LocalDateTime fechaHora);
}
