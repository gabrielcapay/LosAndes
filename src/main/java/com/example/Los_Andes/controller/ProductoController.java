package com.example.Los_Andes.controller;

import com.example.Los_Andes.model.Producto;
import com.example.Los_Andes.model.Usuario;
import com.example.Los_Andes.service.ICategoriaService;
import com.example.Los_Andes.service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductoController {
    @Autowired
    private IProductoService productoService;
    @GetMapping("v1/producto/{id}")
    public Producto buscarProducto(@PathVariable Long id){
        return productoService.findProducto(id);
    }

    @GetMapping("v1/producto/")
    public List<Producto> buscarUsuario() {return productoService.geteProductos();
    }

    @PostMapping("v1/producto/agregar")
    public void agregarProducto(@RequestBody Producto nuevoProducto){
        productoService.saveProducto(nuevoProducto);
    }

    @PutMapping("v1/producto/editar")
    public void editarProducto(@RequestBody Producto producto){
        productoService.editProducto(producto);
    }
}
