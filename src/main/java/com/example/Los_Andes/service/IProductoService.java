package com.example.Los_Andes.service;

import com.example.Los_Andes.model.Cliente;
import com.example.Los_Andes.model.Producto;

import java.util.List;

public interface IProductoService {
    public List<Producto> geteProductos();
    public Producto findProducto(Long id);
    public void saveProducto(Producto nuevoProducto);
    public void deleteProducto(Long id);
    public void editProducto(Producto productoEditado);
}
