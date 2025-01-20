package com.example.Los_Andes.service;

import com.example.Los_Andes.model.Usuario;
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
    public List<Usuario> getUsuarios() {
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario findUsuario(Long id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    @Override
    public void saveUsuario(Usuario nuevoUsuario) {
        usuarioRepository.save(nuevoUsuario);
    }

    @Override
    public void deleteUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }

    @Override
    public void editUsuario(Usuario usuario) {

        if (usuario.getId_usuario() == null || usuarioRepository.existsById(usuario.getId_usuario())){
            throw new EntityNotFoundException("El producto con el ID " + usuario.getId_usuario() + " no existe");
        }
        this.saveUsuario(usuario);
    }
}
