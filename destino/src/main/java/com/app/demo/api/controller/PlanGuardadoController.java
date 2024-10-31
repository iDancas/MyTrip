package com.app.demo.api.controller;

import com.app.demo.domain.dto.PlanGuardadoDTO;
import com.app.demo.domain.response.ResponsePlan;
import com.app.demo.domain.service.PlanGuardadoServices;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class PlanGuardadoController {

    @Autowired
    private PlanGuardadoServices planGuardadoServices;

    @PostMapping("/plan")
    public ResponseEntity<ResponsePlan> guardarPlan(@RequestBody PlanGuardadoDTO planGuardadoDTO) {

        ResponsePlan responsePlan = new ResponsePlan();
        
        PlanGuardadoDTO sitioGuardado = planGuardadoServices.guardarPlanGuardado(planGuardadoDTO);

        if (sitioGuardado != null) {
            responsePlan.setEsValido(true);
            responsePlan.setMensaje("Sitio guardado con exito");
            responsePlan.setPlanGuardado(sitioGuardado);

            return ResponseEntity.ok(responsePlan);
        } else {
            responsePlan.setMensaje("No pudimos guardar el plan, intente nuevamente");
            return ResponseEntity.ok(responsePlan);
        }
    }
    
    @GetMapping("/planes")
    public ResponseEntity<ResponsePlan> obtenerTodosPlanes() {
        List<PlanGuardadoDTO> planesGuardados = planGuardadoServices.obtenerTodosPlanes();
        
        ResponsePlan responsePlan = new ResponsePlan();
        
        if (!planesGuardados.isEmpty()) {
            responsePlan.setEsValido(true);
            responsePlan.setMensaje("Planes encontrados");
            responsePlan.setListaPlanesGuardados(planesGuardados);
            return ResponseEntity.ok(responsePlan);
        } else {
            responsePlan.setMensaje("No se encontraron planes");
            return ResponseEntity.notFound().build();
        }
    }
    
    @GetMapping("/planes/{idUsuario}")
    public ResponseEntity<ResponsePlan> obtenerTodosPlanesPorUsuario(@PathVariable Long idUsuario) {
        List<PlanGuardadoDTO> planesGuardados = planGuardadoServices.obtenerPlanesUsuario(idUsuario);
        ResponsePlan responsePlan = new ResponsePlan();
        if (!planesGuardados.isEmpty()) {
            responsePlan.setEsValido(true);
            responsePlan.setMensaje("Planes encontrados");
            responsePlan.setListaPlanesGuardados(planesGuardados);
            return ResponseEntity.ok(responsePlan);
        } else {
            responsePlan.setMensaje("No se encontraron planes para el usuario con ID " + idUsuario);
            return ResponseEntity.notFound().build();
        }
    }

}
