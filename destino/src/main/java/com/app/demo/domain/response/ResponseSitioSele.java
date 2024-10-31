package com.app.demo.domain.response;

import com.app.demo.domain.dto.SitioSeleccionadoDTO;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseSitioSele {
    private String mensaje;
    private boolean esValido;
    private SitioSeleccionadoDTO sitioSele;
    private List<SitioSeleccionadoDTO> listaSitiosSele;
}
