package com.app.demo.domain.dto;

import com.app.demo.persistence.entity.Usuario;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlanGuardadoDTO {

    private Long idPlanGuardado;
    
    private String nombrePlan;
    private List<String> actividades;
    private List<Long> telefonos;
    private List<String> categorias;
    private List<Double> precios;
    private List<String> emails;
    
    private Usuario usuario;
}
