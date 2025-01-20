package com.example.Los_Andes.service;

import com.example.Los_Andes.dto.ProductoDTO;
import com.example.Los_Andes.model.Cliente;
import com.example.Los_Andes.model.Producto;
import com.example.Los_Andes.repository.ProductoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductoService implements IProductoService {

    @Autowired
    private ProductoRepository productoRepository;
    @Override
    public List<Producto> geteProductos() {
        return productoRepository.findAll();
    }

    public List<ProductoDTO> getProductos() {
        List<Producto> listaProductos = productoRepository.findAll();

        List<ProductoDTO> listaProductosResponse = new ArrayList<>() ;

        for (Producto producto:listaProductos) {
            ProductoDTO productoDTO = new ProductoDTO();
            productoDTO.setId_producto(producto.getId_producto());
            productoDTO.setNombre_producto(producto.getNombre_producto());
            productoDTO.setPrecio_producto(producto.getPrecio_producto());
            productoDTO.setStock_producto(producto.getStock_producto());
            productoDTO.setCategoria_producto(producto.getCategoria_producto().getNombre_categoria());
            listaProductosResponse.add(productoDTO);
        }

        return listaProductosResponse;
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
        if (productoEditado.getId_producto() == null || productoRepository.existsById(productoEditado.getId_producto())){
            throw new EntityNotFoundException("El producto con el ID " + productoEditado.getId_producto() + " no existe");
        }
        productoRepository.save(productoEditado);
    }

}
