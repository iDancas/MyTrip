package com.app.demo.domain.service;

import com.app.demo.domain.dto.SitioDTO;
import com.app.demo.domain.mapper.SitioMapper;
import com.app.demo.persistence.entity.Sitio;
import com.app.demo.persistence.repository.SitioRepository;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SitioServices {

    @Autowired
    private SitioRepository sitioRepo;

    public SitioDTO agregarSitio(SitioDTO sitioDTO) {

        Sitio sitioGuardado = sitioRepo.save(SitioMapper.toEntity(sitioDTO));

        sitioDTO.setIdSitio(sitioGuardado.getIdSitio());

        return sitioDTO;
    }

    public List<SitioDTO> obtenerSitios() {
        return sitioRepo.findAll().stream().map(SitioMapper::toDTO).collect(Collectors.toList());
    }
    
    public List<SitioDTO> obtenerSitiosEmpresa(Long id) {
        return sitioRepo.findByUsuarioIdUsuario(id).stream().map(SitioMapper::toDTO).collect(Collectors.toList());
    }

    public SitioDTO actualizarSitio(SitioDTO sitioDTO) {
        Optional<Sitio> optionalSitio = sitioRepo.findById(sitioDTO.getIdSitio());

        if (optionalSitio.isPresent()) {
            Sitio sitio = optionalSitio.get();
            
            sitio.setTipoSitio(sitioDTO.getTipoSitio());
            sitio.setNombre(sitioDTO.getNombre());
            sitio.setDireccion(sitioDTO.getDireccion());
            sitio.setHorario(sitioDTO.getHorario());
            sitio.setEmail(sitioDTO.getEmail());
            sitio.setTelefono(sitioDTO.getTelefono());
            sitio.setPrecio(sitioDTO.getPrecio());
            sitio.setInformacionGeneral(sitioDTO.getInformacionGeneral());
            sitio.setDisponibilidad(sitioDTO.isDisponibilidad());
            sitio.setCantidad(sitioDTO.getCantidad());

            sitioRepo.save(sitio);

            return sitioDTO;
        } else {
            return null;
        }
    }

    public SitioDTO obtenerSitio(Long id) {
        Optional<Sitio> optionalSitio = sitioRepo.findById(id);

        if (optionalSitio.isPresent()) {
            Sitio sitio = optionalSitio.get();
            return SitioMapper.toDTO(sitio);
        } else {
            return null;
        }
    }

    public boolean eliminarSitio(Long id) {

        Optional<Sitio> optionalSitio = sitioRepo.findById(id);

        if (optionalSitio.isPresent()) {
            sitioRepo.deleteById(id);
            return true;
        } else {
            return false;
        }

    }

    public boolean validarSiExisteNombre(String nombre) {
        return sitioRepo.existsByNombre(nombre);
    }

}
