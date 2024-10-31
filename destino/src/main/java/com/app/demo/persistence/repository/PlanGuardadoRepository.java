package com.app.demo.persistence.repository;

import com.app.demo.persistence.entity.PlanGuardado;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlanGuardadoRepository extends JpaRepository<PlanGuardado, Long>{
    List<PlanGuardado> findByUsuarioIdUsuario(Long id);
}
