package com.example.Los_Andes.service;

import com.example.Los_Andes.model.Vendedor;
import com.example.Los_Andes.repository.UsuarioRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService implements IUsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;


    @Override
    public List<Vendedor> getUsuarios() {
        return usuarioRepository.findAll();
    }

    @Override
    public Vendedor findUsuario(Long id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    @Override
    public void saveUsuario(Vendedor nuevoVendedor) {
        usuarioRepository.save(nuevoVendedor);
    }

    @Override
    public void deleteUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }

    @Override
    public void editUsuario(Vendedor vendedor) {

        if (vendedor.getId_vendedor() == null || usuarioRepository.existsById(vendedor.getId_vendedor())){
            throw new EntityNotFoundException("El producto con el ID " + vendedor.getId_vendedor() + " no existe");
        }
        this.saveUsuario(vendedor);
    }
}
