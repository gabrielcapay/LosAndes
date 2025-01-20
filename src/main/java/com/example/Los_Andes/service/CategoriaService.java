package com.example.Los_Andes.service;

import com.example.Los_Andes.model.Categoria;
import com.example.Los_Andes.repository.CategoriaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService implements ICategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;
    @Override
    public List<Categoria> getCategoria() {
        return categoriaRepository.findAll();
    }

    @Override
    public Categoria findCategoria(Long id) {
        return categoriaRepository.findById(id).orElse(null);
    }

    @Override
    public void saveCategoria(Categoria nuevaCategoria) {
        categoriaRepository.save(nuevaCategoria);
    }

    @Override
    public void deleteCategoria(Long id) {
        categoriaRepository.deleteById(id);
    }

    @Override
    public void editCategoria(Categoria categoriaEdit) {

        if (categoriaEdit.getId_categoria() == null || !categoriaRepository.existsById(categoriaEdit.getId_categoria())) {
            throw new EntityNotFoundException("La categoría con el ID " + categoriaEdit.getId_categoria() + " no existe");
        }
        this.saveCategoria(categoriaEdit);
    }
}
