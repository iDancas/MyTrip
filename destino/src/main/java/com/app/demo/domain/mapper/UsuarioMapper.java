package com.app.demo.domain.mapper;

import com.app.demo.domain.dto.UsuarioDTO;
import com.app.demo.persistence.entity.Usuario;

public class UsuarioMapper {

    public static UsuarioDTO usuarioToDTO(Usuario usuario) {
        UsuarioDTO usuarioDTO = new UsuarioDTO();
        usuarioDTO.setIdUsuario(usuario.getIdUsuario());
        usuarioDTO.setTipoDocumento(usuario.getTipoDocumento());
        usuarioDTO.setNumeroDocumento(usuario.getNumeroDocumento());
        usuarioDTO.setNombreCompleto(usuario.getNombreCompleto());
        usuarioDTO.setNumeroTelefono(usuario.getNumeroTelefono());
        usuarioDTO.setEmail(usuario.getEmail());
        usuarioDTO.setNombreUsuario(usuario.getNombreUsuario());
        usuarioDTO.setPresupuesto(usuario.getPresupuesto());
        
        return usuarioDTO;
    }

    public static Usuario dtoToUsuario(UsuarioDTO usuarioDTO) {
        Usuario usuario = new Usuario();
        usuario.setIdUsuario(usuarioDTO.getIdUsuario());
        usuario.setTipoDocumento(usuarioDTO.getTipoDocumento());
        usuario.setNumeroDocumento(usuarioDTO.getNumeroDocumento());
        usuario.setNombreCompleto(usuarioDTO.getNombreCompleto());
        usuario.setNumeroTelefono(usuarioDTO.getNumeroTelefono());
        usuario.setEmail(usuarioDTO.getEmail());
        usuario.setNombreUsuario(usuarioDTO.getNombreUsuario());
        usuario.setPassword(usuarioDTO.getPassword());
        usuario.setPresupuesto(usuarioDTO.getPresupuesto());
        
        return usuario;
    }
}
