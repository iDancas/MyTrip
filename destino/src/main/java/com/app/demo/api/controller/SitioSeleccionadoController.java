package com.app.demo.api.controller;

import com.app.demo.domain.dto.SitioSeleccionadoDTO;
import com.app.demo.domain.response.ResponseSitioSele;
import com.app.demo.domain.service.SitioSeleccionadoServices;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class SitioSeleccionadoController {

    @Autowired
    private SitioSeleccionadoServices sitioSeleccionadoServices;

    @PostMapping("/sitioseleccionado")
    public ResponseEntity<ResponseSitioSele> agregarSitio(@RequestBody SitioSeleccionadoDTO sitioSeleccionadoDTO) {
        ResponseSitioSele responseSS = new ResponseSitioSele();
        boolean yaLaEligio = sitioSeleccionadoServices.validarSiUsuarioYaSeleccionoEstaActividad(
                sitioSeleccionadoDTO.getSitio().getIdSitio(),
                sitioSeleccionadoDTO.getUsuario().getIdUsuario()
        );

        if (yaLaEligio) {
            responseSS.setEsValido(false);
            responseSS.setMensaje("Solo puedes elegir una vez esta actividad");
            return ResponseEntity.badRequest().body(responseSS);
        }

        SitioSeleccionadoDTO sitioGuardado = sitioSeleccionadoServices.agregarSitio(sitioSeleccionadoDTO);

        if (sitioGuardado != null) {
            responseSS.setEsValido(true);
            responseSS.setMensaje("Seleccionaste con exito esta actividad");
            responseSS.setSitioSele(sitioSeleccionadoDTO);

            return ResponseEntity.ok(responseSS);
        } else {
            responseSS.setEsValido(false);
            responseSS.setMensaje("No se selecciono con exito esta actividad");

            return ResponseEntity.ok(responseSS);
        }

    }

    @GetMapping("/sitioseleccionados/{id}/usuario")
    public ResponseEntity<List<SitioSeleccionadoDTO>> obtenerSitiosSeleccionadosUsuario(@PathVariable Long id) {
        List<SitioSeleccionadoDTO> sitiosSeleccionados = sitioSeleccionadoServices.obtenerSitiosSeleccionadosUsuario(id);
        return ResponseEntity.ok(sitiosSeleccionados);
    }

    @DeleteMapping("/sitioseleccionado/{id}")
    public ResponseEntity<?> eliminarSitioSele(@PathVariable Long id) {
        boolean seBorro = sitioSeleccionadoServices.eliminarActividad(id);

        if (seBorro) {
            return ResponseEntity.ok("Se elimino correctamente");

        } else {
            return ResponseEntity.badRequest().body("No se elimino correctamente");
        }
    }

}
