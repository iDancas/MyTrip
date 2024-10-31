package com.app.demo.persistence.entity;

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
@Table(name = "SitioSeleccionado")
public class SitioSeleccionadoUsuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSitioSeleccionado; 
    
    @ManyToOne
    @JoinColumn(name = "idSitio")
    private Sitio sitio;
    
    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;
}
