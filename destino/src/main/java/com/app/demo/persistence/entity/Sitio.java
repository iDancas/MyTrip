package com.app.demo.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Sitios")
public class Sitio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSitio;
    private String tipoSitio;
    @Column(unique = true)
    private String nombre;
    private String direccion;
    private String horario;
    private String email;
    private long telefono;
    private double precio;
    private String informacionGeneral;
    private int cantidad;
    private boolean disponibilidad;
    
    @ManyToOne
    @JoinColumn(name = "idEmpresa")
    private Usuario usuario;
}
