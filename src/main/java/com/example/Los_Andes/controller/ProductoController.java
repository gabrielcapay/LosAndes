package com.example.Los_Andes.controller;

import com.example.Los_Andes.dto.ProductoDTO;
import com.example.Los_Andes.model.Producto;
import com.example.Los_Andes.service.IProductoService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @GetMapping("v1/producto/detalles")
    public List<Producto> buscarProductos() {return productoService.geteProductos();
    }


    @GetMapping("v1/producto")
    public ResponseEntity<?> ordernarDesc(@RequestParam(required = false) String orden) {

        try {
            return new ResponseEntity<>(productoService.getProductos(orden), HttpStatus.OK);
        } catch (EntityNotFoundException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }


    @PostMapping("v1/producto")
    public void agregarProducto(@RequestBody Producto nuevoProducto){
        productoService.saveProducto(nuevoProducto);
    }

    @PutMapping("v1/producto")
    public ResponseEntity<String> editarProducto(@RequestBody Producto producto){
        try {
            productoService.editProducto(producto);
            return new ResponseEntity<>("Los datos fue actualizados correctamente", HttpStatus.OK);
        }
        catch (EntityNotFoundException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}
