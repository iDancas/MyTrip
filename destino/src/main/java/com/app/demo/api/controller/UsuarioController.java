package com.app.demo.api.controller;

import com.app.demo.domain.response.ResponseUsuario;
import com.app.demo.domain.dto.UsuarioDTO;
import com.app.demo.domain.dto.UsuarioIniciar;
import com.app.demo.domain.service.UsuarioServices;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class UsuarioController {

    @Autowired
    private UsuarioServices usuarioServices;

    @PostMapping("/usuario")
    public ResponseEntity<ResponseUsuario> guardarUsuario(@RequestBody UsuarioDTO usuarioDTO) {

        ResponseUsuario responseUsuario = new ResponseUsuario();
        responseUsuario.setEsValido(false);
        responseUsuario.setUsuario(null);

        if (usuarioServices.validarSiExisteEmail(usuarioDTO.getEmail())) {

            responseUsuario.setMensaje("Este email ya existe en la base de datos");

            return ResponseEntity.badRequest().body(responseUsuario);
        }

        if (usuarioServices.validarSiExisteDocumento(usuarioDTO.getNumeroDocumento())) {
            responseUsuario.setMensaje("Este documento ya existe en la base de datos");

            return ResponseEntity.badRequest().body(responseUsuario);
        }

        if (usuarioServices.validarSiExisteNombreUsuario(usuarioDTO.getNombreUsuario())) {
            responseUsuario.setMensaje("Este nombre de usuario ya existe en la base de datos");

            return ResponseEntity.badRequest().body(responseUsuario);
        }

        if (usuarioServices.validarSiExisteTelefono(usuarioDTO.getNumeroTelefono())) {
            responseUsuario.setMensaje("Este telefono ya existe en la base de datos");

            return ResponseEntity.badRequest().body(responseUsuario);
        }

        UsuarioDTO usuGuardado = usuarioServices.registrarUsuario(usuarioDTO);

        responseUsuario.setEsValido(true);
        responseUsuario.setMensaje("Usuario guardado con exito");
        responseUsuario.setUsuario(usuGuardado);

        return ResponseEntity.ok(responseUsuario);

    }

    @PostMapping("/login")
    public ResponseEntity<ResponseUsuario> iniciarSesion(@RequestBody UsuarioIniciar usuarioIniciar) {
        ResponseUsuario respUsu = new ResponseUsuario();
        
        UsuarioDTO usuIngresado = usuarioServices.iniciarSesion(usuarioIniciar.getEmail(), usuarioIniciar.getPassword());

        if (usuIngresado == null) {
            respUsu.setEsValido(false);
            respUsu.setMensaje("Usuario o contraseña incorrectas");
            respUsu.setUsuario(null);

            return ResponseEntity.badRequest().body(respUsu);
        } else {
            respUsu.setEsValido(true);
            respUsu.setMensaje("Inicio correctamente");
            respUsu.setUsuario(usuIngresado);
            return ResponseEntity.ok(respUsu);
        }
    }
    
    @GetMapping("/usuarios")
    public ResponseEntity<ResponseUsuario> obtenerUsuarios() {
        List<UsuarioDTO> usuarios = usuarioServices.obtenerUsuarios();
        
        ResponseUsuario respUsu = new ResponseUsuario();
        
        if (usuarios.size() > 0) {
            respUsu.setEsValido(true);
            respUsu.setMensaje("Se encontraron estos usuarios");
            respUsu.setUsuarios(usuarios);
            
            return ResponseEntity.ok(respUsu);
        } else {
            respUsu.setEsValido(false);
            respUsu.setMensaje("No se encontraron usuarios");
            respUsu.setUsuarios(usuarios);
            
            return ResponseEntity.ok(respUsu);
        }
        
    }
    
    @PutMapping("/usuario/{id}")
    public ResponseEntity<ResponseUsuario> actualizarPresupuesto(@PathVariable Long id, @RequestBody UsuarioDTO usuarioDTO) {
        UsuarioDTO usuarioActualizado = usuarioServices.actualizarPresupuesto(usuarioDTO);
        
        ResponseUsuario respUsu = new ResponseUsuario();
        
        if (usuarioActualizado != null) {
            respUsu.setEsValido(true);
            respUsu.setMensaje("Usuario actualizado con exito");
            respUsu.setUsuario(usuarioActualizado);
            
            return ResponseEntity.ok(respUsu);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
