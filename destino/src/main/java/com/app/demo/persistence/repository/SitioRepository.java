package com.app.demo.persistence.repository;

import com.app.demo.persistence.entity.Sitio;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SitioRepository extends JpaRepository<Sitio, Long>{
    boolean existsByNombre(String nombre);
    
    List<Sitio> findByUsuarioIdUsuario(Long id);
}
