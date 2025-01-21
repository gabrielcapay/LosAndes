package com.example.Los_Andes.service;



import com.example.Los_Andes.dto.ClienteDTO;
import com.example.Los_Andes.model.Cliente;
import com.example.Los_Andes.repository.ClienteRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClienteService implements IClienteService{

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public List<ClienteDTO> getClientes() {

        List<ClienteDTO> clienteRespuesta = new ArrayList<>();


        for (Cliente clienteRepository: clienteRepository.findAll()) {
            ClienteDTO cliente = new ClienteDTO();
            cliente.setId_cliente(clienteRepository.getId_cliente());
            cliente.setNombre_cliente(clienteRepository.getNombre_cliente());
            cliente.setApelido_cliente(clienteRepository.getApelido_cliente());
            cliente.setCorreo_cliente(clienteRepository.getCorreo_cliente());
            cliente.setTelefono_cliente(clienteRepository.getTelefono_cliente());
            clienteRespuesta.add(cliente);
        }

        return clienteRespuesta;
    }

    @Override
    public ClienteDTO findCliente(Long id) {
        Cliente clienteRepo = clienteRepository.findById(id).orElse(null);

        ClienteDTO clienteRespuesta = new ClienteDTO();
        clienteRespuesta.setId_cliente(clienteRepo.getId_cliente());
        clienteRespuesta.setNombre_cliente(clienteRepo.getNombre_cliente());
        clienteRespuesta.setApelido_cliente(clienteRepo.getApelido_cliente());
        clienteRespuesta.setCorreo_cliente(clienteRepo.getCorreo_cliente());
        clienteRespuesta.setTelefono_cliente(clienteRepo.getTelefono_cliente());

        return clienteRespuesta;
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
