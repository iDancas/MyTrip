package com.app.demo.domain.mapper;

import com.app.demo.domain.dto.SitioDTO;
import com.app.demo.persistence.entity.Sitio;

public class SitioMapper {

    public static SitioDTO toDTO(Sitio sitio) {
        SitioDTO sitioDTO = new SitioDTO();
        
        sitioDTO.setIdSitio(sitio.getIdSitio());
        sitioDTO.setTipoSitio(sitio.getTipoSitio());
        sitioDTO.setNombre(sitio.getNombre());
        sitioDTO.setDireccion(sitio.getDireccion());
        sitioDTO.setHorario(sitio.getHorario());
        sitioDTO.setEmail(sitio.getEmail());
        sitioDTO.setTelefono(sitio.getTelefono());
        sitioDTO.setPrecio(sitio.getPrecio());
        sitioDTO.setInformacionGeneral(sitio.getInformacionGeneral());
        sitioDTO.setDisponibilidad(sitio.isDisponibilidad());
        sitioDTO.setCantidad(sitio.getCantidad());
        sitioDTO.setUsuario(sitio.getUsuario());
        
        return sitioDTO;
    }

    public static Sitio toEntity(SitioDTO sitioDTO) {
        Sitio sitio = new Sitio();

        sitio.setIdSitio(sitioDTO.getIdSitio());
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
        sitio.setUsuario(sitioDTO.getUsuario());

        return sitio;
    }
}
