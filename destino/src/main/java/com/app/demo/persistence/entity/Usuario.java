package com.app.demo.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuario;
    
    private String tipoDocumento;
    @Column(unique = true)
    private long numeroDocumento;
    private String nombreCompleto;
    @Column(unique = true)
    private long numeroTelefono;
    @Column(unique = true)
    private String email;
    @Column(unique = true)
    private String nombreUsuario;
    private String password;
    private long presupuesto;
}
