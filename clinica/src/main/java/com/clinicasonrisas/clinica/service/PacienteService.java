package com.clinicasonrisas.clinica.service;

import com.clinicasonrisas.clinica.model.Paciente;
import com.clinicasonrisas.clinica.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;

    public Paciente createPaciente(Paciente paciente) {
        return pacienteRepository.save(paciente);
    }
}
