package com.app.demo.domain.service;

import com.app.demo.domain.dto.PlanGuardadoDTO;
import com.app.demo.domain.mapper.PlanGuardadoMapper;
import com.app.demo.persistence.entity.PlanGuardado;
import com.app.demo.persistence.repository.PlanGuardadoRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlanGuardadoServices {

    @Autowired
    private PlanGuardadoRepository planGuardadoRepository;

    public PlanGuardadoDTO guardarPlanGuardado(PlanGuardadoDTO planGuardadoDTO) {
        PlanGuardado planGuardado = planGuardadoRepository.save(PlanGuardadoMapper.toEntity(planGuardadoDTO));

        if (planGuardado != null) {
            planGuardadoDTO.setIdPlanGuardado(planGuardado.getIdPlanGuardado());

            return planGuardadoDTO;
        } else {
            return null;
        }

    }

    public List<PlanGuardadoDTO> obtenerPlanesUsuario(Long id) {
        return planGuardadoRepository.findByUsuarioIdUsuario(id).stream().map(PlanGuardadoMapper::toDTO).collect(Collectors.toList());
    }
    
    public List<PlanGuardadoDTO> obtenerTodosPlanes() {
        return planGuardadoRepository.findAll().stream().map(PlanGuardadoMapper::toDTO).collect(Collectors.toList());
    }

}
