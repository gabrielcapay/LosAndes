package com.example.Los_Andes.controller;

import com.example.Los_Andes.model.Categoria;
import com.example.Los_Andes.model.Venta;
import com.example.Los_Andes.service.ICategoriaService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
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

    @GetMapping("v1/categoria")
    public List<Categoria> buscarTodasLasVentas(){
        return categoriaService.getCategoria();
    }

    @PostMapping("v1/categoria")
    public ResponseEntity<String> registrarCateogira(@RequestBody Categoria nuevaCategoria){
        categoriaService.saveCategoria(nuevaCategoria);
        return new ResponseEntity<>("La categoria fue registrada correctamente", HttpStatus.OK);
    }

    @PutMapping("v1/categoria")
    public ResponseEntity<String> editarCategoria(@RequestBody Categoria categoria) {
        try {
            categoriaService.editCategoria(categoria);
            return new ResponseEntity<>("La categoría fue actualizada correctamente", HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

}
