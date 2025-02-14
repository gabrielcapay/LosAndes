package com.example.Los_Andes.service;

import com.example.Los_Andes.model.Vendedor;

import java.util.List;

public interface IVendedorService {

    public List<Vendedor> getUsuarios();
    public Vendedor findUsuario(Long id);
    public void saveUsuario(Vendedor nuevoVendedor);
    public void deleteUsuario(Long id);
    public void editUsuario(Vendedor vendedor);
}
