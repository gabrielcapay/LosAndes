package com.example.Los_Andes.controller;

import com.example.Los_Andes.model.Vendedor;
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
    public Vendedor buscarUsuario(@PathVariable Long id){
        return usuarioService.findUsuario(id);
    }

    @GetMapping("v1/usuario")
    public List<Vendedor> buscarUsuario() {return usuarioService.getUsuarios();
    }

    @PostMapping("v1/usuario")
    public void nuevoUsuario(@RequestBody Vendedor nuevoVendedor){
        usuarioService.saveUsuario(nuevoVendedor);
    }

    @PutMapping("v1/usuario")
    public ResponseEntity<String> editarUsuario(@RequestBody Vendedor vendedor){
        usuarioService.editUsuario(vendedor);

        try {
            usuarioService.editUsuario(vendedor);
            return new ResponseEntity<>("Los datos fue actualizados correctamente", HttpStatus.OK);
        }
        catch (EntityNotFoundException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

}
