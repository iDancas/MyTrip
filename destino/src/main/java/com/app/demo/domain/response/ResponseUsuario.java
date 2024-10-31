package com.app.demo.domain.response;

import com.app.demo.domain.dto.UsuarioDTO;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseUsuario {
    
    private String mensaje;
    private boolean esValido;
    private UsuarioDTO usuario;
    private List<UsuarioDTO> usuarios;
    
}
