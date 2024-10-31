package com.app.demo.domain.dto;

import com.app.demo.persistence.entity.Usuario;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SitioDTO {
    private Long idSitio;
    private String tipoSitio;
    private String nombre;
    private String direccion;
    private String horario;
    private String email;
    private long telefono;
    private double precio;
    private String informacionGeneral;
    private int cantidad;
    private boolean disponibilidad;
    private Usuario usuario;
}
