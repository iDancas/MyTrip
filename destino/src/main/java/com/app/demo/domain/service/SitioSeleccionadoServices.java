package com.app.demo.domain.service;

import com.app.demo.domain.dto.SitioSeleccionadoDTO;
import com.app.demo.domain.mapper.SitioSeleMapper;
import com.app.demo.persistence.entity.SitioSeleccionadoUsuario;
import com.app.demo.persistence.repository.SitioSeleccionadoRepository;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SitioSeleccionadoServices {
    
    @Autowired
    private SitioSeleccionadoRepository sitioSeleRepo;

    public SitioSeleccionadoDTO agregarSitio(SitioSeleccionadoDTO sitioSeleDTO) {
        
        SitioSeleccionadoUsuario sitioGuardado = sitioSeleRepo.save(SitioSeleMapper.toEntity(sitioSeleDTO));

        sitioSeleDTO.setIdSitioSeleccionado(sitioGuardado.getIdSitioSeleccionado());

        return sitioSeleDTO;
    }

    public List<SitioSeleccionadoDTO> obtenerSitiosSeleccionadosUsuario(Long id) {
        return sitioSeleRepo.findByUsuarioIdUsuario(id).stream().map(SitioSeleMapper::toDTO).collect(Collectors.toList());
    }
    
    public boolean validarSiUsuarioYaSeleccionoEstaActividad(Long idSitio, Long idUsuario) {
        return sitioSeleRepo.existsBySitioIdSitioAndUsuarioIdUsuario(idSitio, idUsuario);
    }
    
    public boolean eliminarActividad(Long id) {

        Optional<SitioSeleccionadoUsuario> optionalSitio = sitioSeleRepo.findById(id);

        if (optionalSitio.isPresent()) {
            sitioSeleRepo.deleteById(id);
            return true;
        } else {
            return false;
        }

    }
}
