package com.clinicasonrisas.clinica.controller;

import com.clinicasonrisas.clinica.model.Dentista;
import com.clinicasonrisas.clinica.service.DentistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/dentistas")
public class DentistaController {

    @Autowired
    private DentistaService dentistaService;

    @GetMapping
    public List<Dentista> getAllDentistas() {
        return dentistaService.getAllDentistas();
    }
}
