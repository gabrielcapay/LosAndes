package com.example.Los_Andes.service;

import com.example.Los_Andes.model.Cliente;
import com.example.Los_Andes.model.Producto;
import com.example.Los_Andes.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService implements IProductoService {

    @Autowired
    private ProductoRepository productoRepository;
    @Override
    public List<Producto> geteProductos() {
        return productoRepository.findAll();
    }

    @Override
    public Producto findProducto(Long id) {
        return productoRepository.findById(id).orElse(null);
    }

    @Override
    public void saveProducto(Producto nuevoProducto) {
        productoRepository.save(nuevoProducto);
    }

    @Override
    public void deleteProducto(Long id) {
        productoRepository.deleteById(id);
    }

    @Override
    public void editProducto(Producto productoEditado) {
        productoRepository.save(productoEditado);
    }
}
