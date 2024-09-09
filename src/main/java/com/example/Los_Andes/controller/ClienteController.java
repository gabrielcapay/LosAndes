package com.example.Los_Andes.controller;

import com.example.Los_Andes.model.Cliente;

import com.example.Los_Andes.service.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClienteController {

    @Autowired
    private IClienteService clienteService;


    @GetMapping("v1/cliente/{id}")
    public Cliente buscarCliente(@PathVariable Long id){
        return clienteService.findCliente(id);
    }

    @GetMapping("v1/cliente/")
    public List<Cliente> buscarCliente() {return clienteService.getClientes();
    }

    @PostMapping("v1/cliente/registrar")
    public void nuevoCliente(@RequestBody Cliente nuevoCliente){
        clienteService.saveCliente(nuevoCliente);
    }

    @PutMapping("v1/cliente/editar")
    public void editarCliente(@RequestBody Cliente cliente){
        clienteService.editCliente(cliente);
    }
}
