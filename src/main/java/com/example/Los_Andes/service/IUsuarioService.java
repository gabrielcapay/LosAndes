package com.example.Los_Andes.service;

import com.example.Los_Andes.model.Usuario;

import java.util.List;

public interface IUsuarioService {

    public List<Usuario> getUsuarios();
    public Usuario findUsuario(Long id);
    public void saveUsuario(Usuario nuevoUsuario);
    public void deleteUsuario(Long id);
    public void editUsuario(Usuario usuario);
}
