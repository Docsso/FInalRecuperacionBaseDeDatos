package com.clinicasonrisas.clinica.service;

import com.clinicasonrisas.clinica.model.Dentista;
import com.clinicasonrisas.clinica.repository.DentistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DentistaService {

    @Autowired
    private DentistaRepository dentistaRepository;

    public List<Dentista> getAllDentistas() {
        return dentistaRepository.findAll();
    }
}
