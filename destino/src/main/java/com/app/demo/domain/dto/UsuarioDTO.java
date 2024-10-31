package com.app.demo.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDTO {
    private Long idUsuario;
    private String tipoDocumento;
    private long numeroDocumento;
    private String nombreCompleto;
    private long numeroTelefono;
    private String email;
    private String nombreUsuario;
    private String password;
    private long presupuesto;
}
