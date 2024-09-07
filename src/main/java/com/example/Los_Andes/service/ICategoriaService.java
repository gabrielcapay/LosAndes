package com.example.Los_Andes.service;

import com.example.Los_Andes.model.Categoria;
import com.example.Los_Andes.model.Cliente;

import java.util.List;

public interface ICategoriaService {
    public List<Categoria> getCategoria();
    public Categoria findCategoria(Long id);
    public void saveCategoria(Categoria nuevaCategoria);
    public void deleteCategoria(Long id);
    public void editCategoria(Categoria categoriaEdit);
}
