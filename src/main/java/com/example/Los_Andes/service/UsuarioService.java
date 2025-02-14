package com.example.Los_Andes.service;

import com.example.Los_Andes.model.Usuario;
import com.example.Los_Andes.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService implements IUserService{

    @Autowired
    private UserRepository iUserService;

    @Override
    public List<Usuario> findAll() {
        return iUserService.findAll();
    }

    @Override
    public Optional<Usuario> findById(Long id) {
        return iUserService.findById(id);
    }

    @Override
    public Usuario save(Usuario userSec) {
        return iUserService.save(userSec);
    }

    @Override
    public void deleteById(Long id) {
        iUserService.deleteById(id);
    }

    @Override
    public void update(Usuario userSec) {
        this.save(userSec);
    }
}
