package com.clinicasonrisas.clinica.controller;

import com.clinicasonrisas.clinica.controller.dto.CitaRequestDTO;
import com.clinicasonrisas.clinica.model.Cita;
import com.clinicasonrisas.clinica.service.CitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/citas")
public class CitaController {

    @Autowired
    private CitaService citaService;

    @GetMapping
    public List<Cita> getAllCitas() {
        return citaService.getAllCitas();
    }

    @PostMapping
    public ResponseEntity<?> agendarCita(@RequestBody CitaRequestDTO request) {
        try {
            Cita nuevaCita = citaService.agendarCita(
                request.getPacienteId(),
                request.getDentistaId(),
                request.getFechaHora()
            );
            return ResponseEntity.ok(nuevaCita);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
