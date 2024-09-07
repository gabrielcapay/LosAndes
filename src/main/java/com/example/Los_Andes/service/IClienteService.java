package com.example.Los_Andes.service;

import com.example.Los_Andes.model.Cliente;

import java.util.List;

public interface IClienteService {

    public List<Cliente> getCliente();
    public Cliente findCliente(Long id);
    public void saveCliente(Cliente nuevoCliente);
    public void deleteCliente(Long id);
    public void editCliente(Cliente usuario);
}
