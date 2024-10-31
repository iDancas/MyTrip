package com.app.demo.domain.service;

import com.app.demo.domain.dto.UsuarioDTO;
import com.app.demo.domain.mapper.UsuarioMapper;
import com.app.demo.persistence.entity.Usuario;
import com.app.demo.persistence.repository.UsuarioRepository;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServices {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public UsuarioDTO registrarUsuario(UsuarioDTO usuarioDTO) {
        Usuario usuGuardado = usuarioRepository.save(UsuarioMapper.dtoToUsuario(usuarioDTO));

        usuarioDTO.setIdUsuario(usuGuardado.getIdUsuario());

        return usuarioDTO;

    }

    public UsuarioDTO iniciarSesion(String email, String pas) {

        Optional<Usuario> usuEncontrado = usuarioRepository.findByEmailAndPassword(email, pas);

        if (usuEncontrado.isPresent()) {
            return UsuarioMapper.usuarioToDTO(usuEncontrado.orElse(null));
        } else {
            return null;
        }

    }
    
    public List<UsuarioDTO> obtenerUsuarios() {
        return usuarioRepository.findAll().stream().map(UsuarioMapper::usuarioToDTO).collect(Collectors.toList());
    }
    
      public UsuarioDTO actualizarPresupuesto(UsuarioDTO usuarioDTO) {
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(usuarioDTO.getIdUsuario());

        if (usuarioOptional.isPresent()) {
            Usuario usuario = usuarioOptional.get();
            usuario.setPresupuesto(usuarioDTO.getPresupuesto());
            Usuario usuarioActualizado = usuarioRepository.save(usuario);
            return UsuarioMapper.usuarioToDTO(usuarioActualizado);
        } else {
            return null;
        }
    }
      
    public boolean validarSiExisteEmail(String email) {
        return usuarioRepository.existsByEmail(email);
    }

    public boolean validarSiExisteTelefono(long telefono) {
        return usuarioRepository.existsByNumeroTelefono(telefono);
    }

    public boolean validarSiExisteNombreUsuario(String nombreUsuario) {
        return usuarioRepository.existsByNombreUsuario(nombreUsuario);
    }

    public boolean validarSiExisteDocumento(long numeroDocumento) {
        return usuarioRepository.existsByNumeroDocumento(numeroDocumento);
    }

}
