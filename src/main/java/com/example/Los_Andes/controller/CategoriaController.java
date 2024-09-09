package com.example.Los_Andes.controller;

import com.example.Los_Andes.model.Categoria;
import com.example.Los_Andes.model.Venta;
import com.example.Los_Andes.service.ICategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoriaController {
    @Autowired
    private ICategoriaService categoriaService;

    @GetMapping("v1/categoria/{id}")
    public Categoria buscarUsuario(@PathVariable Long id){
        return categoriaService.findCategoria(id);
    }

    @GetMapping("v1/categoria/listar")
    public List<Categoria> buscarTodasLasVentas(){
        return categoriaService.getCategoria();
    }

    @PostMapping("v1/categoria/registrar")
    public void registrarCateogira(@RequestBody Categoria nuevaCategoria){
        categoriaService.saveCategoria(nuevaCategoria);
    }

    @PutMapping("v1/categoria/editar")
    public void editarCategoria(@RequestBody Categoria categoria){ //implementar
    }
}
