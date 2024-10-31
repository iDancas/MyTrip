package com.app.demo.persistence.repository;

import com.app.demo.persistence.entity.SitioSeleccionadoUsuario;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SitioSeleccionadoRepository extends JpaRepository<SitioSeleccionadoUsuario, Long>{
    List<SitioSeleccionadoUsuario> findByUsuarioIdUsuario(Long id);
    
    boolean existsBySitioIdSitioAndUsuarioIdUsuario(Long idSitio, Long idUsuario);
}
