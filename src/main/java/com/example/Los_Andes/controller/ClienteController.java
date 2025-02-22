package com.example.Los_Andes.controller;

import com.example.Los_Andes.dto.ClienteCompraDTO;
import com.example.Los_Andes.dto.ClienteDTO;
import com.example.Los_Andes.model.Cliente;

import com.example.Los_Andes.service.IClienteService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClienteController {

    @Autowired
    private IClienteService clienteService;


    @GetMapping("v1/cliente/{id}")
    public ClienteDTO buscarCliente(@PathVariable Long id){
        return clienteService.findCliente(id);
    }

    @GetMapping("v1/cliente/{id}/compras")
    public ClienteCompraDTO buscarComprasCliente(@PathVariable Long id){
        return clienteService.findClienteCompra(id);
    }

    @GetMapping("v1/cliente")
    public List<ClienteDTO> buscarCliente() {return clienteService.getClientes();
    }

    @PostMapping("v1/cliente")
    public ResponseEntity<String> nuevoCliente(@RequestBody Cliente nuevoCliente){
        try {
            clienteService.saveCliente(nuevoCliente);
            return new ResponseEntity<>("El cliente se ha guardo correctamente", HttpStatus.OK);
        }
        catch (EntityNotFoundException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("v1/cliente")
    public ResponseEntity<String> editarCliente(@RequestBody Cliente cliente){
        try {
            clienteService.editCliente(cliente);
            return new ResponseEntity<>("Los datos fue actualizados correctamente", HttpStatus.OK);
        }
        catch (EntityNotFoundException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}
