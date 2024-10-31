package com.app.demo.domain.dto;

import com.app.demo.persistence.entity.Sitio;
import com.app.demo.persistence.entity.Usuario;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SitioSeleccionadoDTO {
    private Long idSitioSeleccionado; 
    private Sitio sitio;
    private Usuario usuario;
}
