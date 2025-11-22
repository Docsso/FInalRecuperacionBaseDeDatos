package com.clinicasonrisas.clinica.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Tratamiento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String nombre;
    private String descripcion;

    @OneToOne
    @JoinColumn(name = "cita_id", nullable = false)
    private Cita cita;
}
