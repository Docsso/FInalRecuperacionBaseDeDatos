package com.clinicasonrisas.clinica.service;

import com.clinicasonrisas.clinica.model.Cita;
import com.clinicasonrisas.clinica.model.Dentista;
import com.clinicasonrisas.clinica.model.Paciente;
import com.clinicasonrisas.clinica.repository.CitaRepository;
import com.clinicasonrisas.clinica.repository.DentistaRepository;
import com.clinicasonrisas.clinica.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class CitaService {

    @Autowired
    private CitaRepository citaRepository;

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private DentistaRepository dentistaRepository;

    public List<Cita> getAllCitas() {
        return citaRepository.findAll();
    }

    public Cita agendarCita(Long pacienteId, Long dentistaId, LocalDateTime fechaHora) throws Exception {
        // Validar que el dentista no tenga una cita a la misma hora
        List<Cita> citasExistentes = citaRepository.findByDentistaIdAndFechaHora(dentistaId, fechaHora);
        if (!citasExistentes.isEmpty()) {
            throw new Exception("El dentista ya tiene una cita agendada a esa hora.");
        }

        // Validar que el paciente y el dentista existan
        Optional<Paciente> pacienteOpt = pacienteRepository.findById(pacienteId);
        if (pacienteOpt.isEmpty()) {
            throw new Exception("El paciente con ID " + pacienteId + " no existe.");
        }

        Optional<Dentista> dentistaOpt = dentistaRepository.findById(dentistaId);
        if (dentistaOpt.isEmpty()) {
            throw new Exception("El dentista con ID " + dentistaId + " no existe.");
        }

        // Crear y guardar la nueva cita
        Cita nuevaCita = new Cita();
        nuevaCita.setPaciente(pacienteOpt.get());
        nuevaCita.setDentista(dentistaOpt.get());
        nuevaCita.setFechaHora(fechaHora);

        return citaRepository.save(nuevaCita);
    }
}
