package com.app.demo.domain.mapper;

import com.app.demo.domain.dto.SitioSeleccionadoDTO;
import com.app.demo.persistence.entity.SitioSeleccionadoUsuario;

public class SitioSeleMapper {
    public static SitioSeleccionadoDTO toDTO(SitioSeleccionadoUsuario sitioSele) {
        SitioSeleccionadoDTO sitioSeleDTO = new SitioSeleccionadoDTO();

        sitioSeleDTO.setIdSitioSeleccionado(sitioSele.getIdSitioSeleccionado());
        sitioSeleDTO.setSitio(sitioSele.getSitio());
        sitioSeleDTO.setUsuario(sitioSele.getUsuario());

        return sitioSeleDTO;
    }

    public static SitioSeleccionadoUsuario toEntity(SitioSeleccionadoDTO sitioSeleDTO) {
        SitioSeleccionadoUsuario sitio = new SitioSeleccionadoUsuario();

        sitio.setIdSitioSeleccionado(sitioSeleDTO.getIdSitioSeleccionado());
        sitio.setSitio(sitioSeleDTO.getSitio());
        sitio.setUsuario(sitioSeleDTO.getUsuario());

        return sitio;
    }
}
