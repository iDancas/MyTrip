package com.app.demo.persistence.repository;

import com.app.demo.persistence.entity.Usuario;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
    
    Optional<Usuario> findByEmailAndPassword(String email, String password);
    
    boolean existsByEmail(String email);
    
    boolean existsByNumeroTelefono(Long telefono);
    
    boolean existsByNombreUsuario(String nombreUsuario);
    
    boolean existsByNumeroDocumento(Long numDocu);
    
}
