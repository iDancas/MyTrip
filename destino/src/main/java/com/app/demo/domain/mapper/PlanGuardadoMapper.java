package com.app.demo.domain.mapper;

import com.app.demo.domain.dto.PlanGuardadoDTO;
import com.app.demo.persistence.entity.PlanGuardado;

public class PlanGuardadoMapper {
     public static PlanGuardadoDTO toDTO(PlanGuardado planGuardado) {
        PlanGuardadoDTO planGuardadoDTO = new PlanGuardadoDTO();
        
        planGuardadoDTO.setIdPlanGuardado(planGuardado.getIdPlanGuardado());
        planGuardadoDTO.setNombrePlan(planGuardado.getNombrePlan());
        planGuardadoDTO.setActividades(planGuardado.getActividades());
        planGuardadoDTO.setCategorias(planGuardado.getCategorias());
        planGuardadoDTO.setEmails(planGuardado.getEmails());
        planGuardadoDTO.setPrecios(planGuardado.getPrecios());
        planGuardadoDTO.setTelefonos(planGuardado.getTelefonos());
        planGuardadoDTO.setUsuario(planGuardado.getUsuario());
        
        return planGuardadoDTO;
    }

    public static PlanGuardado toEntity(PlanGuardadoDTO planGuardadoDTO) {
        PlanGuardado planGuardado = new PlanGuardado();

        planGuardado.setIdPlanGuardado(planGuardadoDTO.getIdPlanGuardado());
        planGuardado.setNombrePlan(planGuardadoDTO.getNombrePlan());
        planGuardado.setActividades(planGuardadoDTO.getActividades());
        planGuardado.setCategorias(planGuardadoDTO.getCategorias());
        planGuardado.setEmails(planGuardadoDTO.getEmails());
        planGuardado.setPrecios(planGuardadoDTO.getPrecios());
        planGuardado.setTelefonos(planGuardadoDTO.getTelefonos());
        planGuardado.setUsuario(planGuardadoDTO.getUsuario());

        return planGuardado;
    }
}
