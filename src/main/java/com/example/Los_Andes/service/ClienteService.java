package com.example.Los_Andes.service;



import com.example.Los_Andes.model.Cliente;
import com.example.Los_Andes.repository.ClienteRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService implements IClienteService{

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public List<Cliente> getClientes() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente findCliente(Long id) {
        return clienteRepository.findById(id).orElse(null);
    }

    @Override
    public void saveCliente(Cliente nuevoUsuario) {
        clienteRepository.save(nuevoUsuario);
    }

    @Override
    public void deleteCliente(Long id) {
        clienteRepository.deleteById(id);
    }

    @Override
    public void editCliente(Cliente usuario) {

        if (usuario.getId_cliente() == null || clienteRepository.existsById(usuario.getId_cliente())){
            throw new EntityNotFoundException("El cliente con el ID " + usuario.getId_cliente() + " no existe");
        }
        this.saveCliente(usuario);
    }
}
