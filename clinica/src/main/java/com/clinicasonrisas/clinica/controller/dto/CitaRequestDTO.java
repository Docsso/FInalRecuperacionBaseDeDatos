package com.clinicasonrisas.clinica.controller.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class CitaRequestDTO {
    private Long pacienteId;
    private Long dentistaId;
    private LocalDateTime fechaHora;
}
