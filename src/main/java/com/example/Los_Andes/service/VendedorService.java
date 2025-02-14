package com.example.Los_Andes.service;

import com.example.Los_Andes.model.Vendedor;
import com.example.Los_Andes.repository.VendedorRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class VendedorService implements IVendedorService {
    @Autowired
    private VendedorRepository usuarioRepository;


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
        nuevoVendedor.setCreatedAt(LocalDateTime.now());
        nuevoVendedor.setUpdatedAt(LocalDateTime.now());
        usuarioRepository.save(nuevoVendedor);
    }

    @Override
    public void deleteUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }

    @Override
    public void editUsuario(Vendedor vendegitdor) {

        if (vendegitdor.getId_vendedor() == null || usuarioRepository.existsById(vendegitdor.getId_vendedor())){
            throw new EntityNotFoundException("El producto con el ID " + vendegitdor.getId_vendedor() + " no existe");
        }
        vendegitdor.setUpdatedAt(LocalDateTime.now());
        this.saveUsuario(vendegitdor);
    }
}
