package com.example.Los_Andes.service;

import com.example.Los_Andes.model.Usuario;

import java.util.List;
import java.util.Optional;

public interface IUserService {
    public List<Usuario> findAll();
    public Optional<Usuario> findById(Long id);
    public Usuario save(Usuario userSec);
    public void deleteById(Long id);
    public void update(Usuario userSec);
}
