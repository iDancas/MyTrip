package com.app.demo.domain.response;

import com.app.demo.domain.dto.SitioDTO;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseSitio {
    private String mensaje;
    private boolean esValido;
    private SitioDTO sitio;
    private List<SitioDTO> listaSitios;
}
