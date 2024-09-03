package com.example.Los_Andes.controller;

import com.example.Los_Andes.model.Usuario;
import com.example.Los_Andes.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UsuarioController {

    @Autowired
    private IUsuarioService usuarioService;

    @GetMapping("v1/usuario/{id}")
    public Usuario buscarUsuario(@PathVariable Long id){
        return usuarioService.findUsuario(id);
    }

    @PostMapping("v1/usuario/agregar")
    public void nuevoUsuario(@RequestBody Usuario nuevoUsuario){
        usuarioService.saveUsuario(nuevoUsuario);
    }

    @PutMapping("v1/usuario/editar")
    public void editarUsuario(@RequestBody Usuario usuario){
        usuarioService.editPersona(usuario);
    }

}
