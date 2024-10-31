package com.app.demo.api.controller;

import com.app.demo.domain.dto.SitioDTO;
import com.app.demo.domain.response.ResponseSitio;
import com.app.demo.domain.service.SitioServices;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class SitioController {

    @Autowired
    private SitioServices sitioServices;

    @PostMapping("/sitio")
    public ResponseEntity<ResponseSitio> agregarSitio(@RequestBody SitioDTO sitioDTO) {

        ResponseSitio responseSitio = new ResponseSitio();

        if (sitioServices.validarSiExisteNombre(sitioDTO.getNombre())) {
            responseSitio.setMensaje("Ya hay un sitio con este nombre en la base de datos");

            return ResponseEntity.badRequest().body(responseSitio);
        }

        SitioDTO sitioGuardado = sitioServices.agregarSitio(sitioDTO);

        if (sitioGuardado != null) {
            responseSitio.setEsValido(true);
            responseSitio.setMensaje("Sitio guardado con exito");
            responseSitio.setSitio(sitioGuardado);

            return ResponseEntity.ok(responseSitio);
        } else {
            responseSitio.setEsValido(false);
            responseSitio.setMensaje("No se pudo guardar el sitio guardado con exito");
            responseSitio.setSitio(sitioGuardado);

            return ResponseEntity.badRequest().body(responseSitio);
        }

    }

    @GetMapping("/sitios")
    public ResponseEntity<ResponseSitio> obtenerListaSitios() {

        List<SitioDTO> listaSitios = sitioServices.obtenerSitios();

        ResponseSitio responseSitio = new ResponseSitio();
        responseSitio.setEsValido(true);
        responseSitio.setListaSitios(listaSitios);
        responseSitio.setMensaje("Sitios obtenidos con exito");

        return ResponseEntity.ok(responseSitio);

    }
    
    @GetMapping("/sitios/{id}/empresa")
    public ResponseEntity<ResponseSitio> obtenerListaSitiosEmpresa(@PathVariable Long id) {
        
        List<SitioDTO> listaSitios = sitioServices.obtenerSitiosEmpresa(id);

        ResponseSitio responseSitio = new ResponseSitio();
        responseSitio.setEsValido(true);
        responseSitio.setListaSitios(listaSitios);
        responseSitio.setMensaje("Sitios obtenidos (Empresa) con exito");

        return ResponseEntity.ok(responseSitio);
        
    }

    @GetMapping("/sitio/{id}")
    public ResponseEntity<ResponseSitio> obtenerSitio(@PathVariable Long id) {

        ResponseSitio responseSitio = new ResponseSitio();
        responseSitio.setEsValido(false);
        responseSitio.setSitio(null);

        SitioDTO sitioObtenido = sitioServices.obtenerSitio(id);

        if (sitioObtenido != null) {
            responseSitio.setEsValido(true);
            responseSitio.setMensaje("Obtuvimos un sitio con éxito");
            responseSitio.setSitio(sitioObtenido);

            return ResponseEntity.ok(responseSitio);
        } else {
            responseSitio.setMensaje("El sitio no se pudo ser obbtenido, quizas no existe");
            return ResponseEntity.badRequest().body(responseSitio);
        }

    }

    @PutMapping("/sitio/{id}")
    public ResponseEntity<ResponseSitio> actualizarSitio(@RequestBody SitioDTO sitioDTO) {
        ResponseSitio responseSitio = new ResponseSitio();
        responseSitio.setEsValido(false);
        responseSitio.setSitio(null);

        SitioDTO sitioActualizado = sitioServices.actualizarSitio(sitioDTO);

        if (sitioActualizado != null) {
            responseSitio.setEsValido(true);
            responseSitio.setMensaje("Sitio actualizado con éxito");
            responseSitio.setSitio(sitioActualizado);

            return ResponseEntity.ok(responseSitio);
        } else {
            responseSitio.setMensaje("El sitio no se pudo actualizar, quizas no existe");
            return ResponseEntity.badRequest().body(responseSitio);
        }
    }

    @DeleteMapping("/sitio/{id}")
    public ResponseEntity<ResponseSitio> eliminarSitio(@PathVariable Long id) {

        ResponseSitio responseSitio = new ResponseSitio();

        boolean seEliminoCorrectamente = sitioServices.eliminarSitio(id);

        if (seEliminoCorrectamente) {

            responseSitio.setEsValido(true);
            responseSitio.setMensaje("Se elimino correctamente");

            return ResponseEntity.ok(responseSitio);
        } else {
            responseSitio.setEsValido(false);
            responseSitio.setMensaje("No se pudo eliminar el sitio, quizas no existe");

            return ResponseEntity.ok(responseSitio);
        }

    }

}
