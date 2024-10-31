package com.app.demo.persistence.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "planGuardado")
public class PlanGuardado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPlanGuardado;
    
    private String nombrePlan;
    private List<String> actividades;
    private List<Long> telefonos;
    private List<String> categorias;
    private List<Double> precios;
    private List<String> emails;
    
    @ManyToOne
    @JoinColumn(name = "idCliente")
    private Usuario usuario;
}
