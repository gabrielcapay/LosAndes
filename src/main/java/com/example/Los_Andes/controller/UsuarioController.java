package com.example.Los_Andes.controller;

import com.example.Los_Andes.model.Usuario;
import com.example.Los_Andes.service.IUsuarioService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UsuarioController {

    @Autowired
    private IUsuarioService usuarioService;

    @GetMapping("v1/usuario/{id}")
    public Usuario buscarUsuario(@PathVariable Long id){
        return usuarioService.findUsuario(id);
    }

    @GetMapping("v1/usuario")
    public List<Usuario> buscarUsuario() {return usuarioService.getUsuarios();
    }

    @PostMapping("v1/usuario")
    public void nuevoUsuario(@RequestBody Usuario nuevoUsuario){
        usuarioService.saveUsuario(nuevoUsuario);
    }

    @PutMapping("v1/usuario")
    public ResponseEntity<String> editarUsuario(@RequestBody Usuario usuario){
        usuarioService.editUsuario(usuario);

        try {
            usuarioService.editUsuario(usuario);
            return new ResponseEntity<>("Los datos fue actualizados correctamente", HttpStatus.OK);
        }
        catch (EntityNotFoundException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

}
