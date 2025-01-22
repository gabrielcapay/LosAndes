package com.example.Los_Andes.service;

import com.example.Los_Andes.dto.ProductoDTO;
import com.example.Los_Andes.model.Cliente;
import com.example.Los_Andes.model.Producto;
import com.example.Los_Andes.repository.ProductoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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

    public List<ProductoDTO> getProductos(String orden) {
        List<Producto> listaProductos = new ArrayList<>();

        if (orden == null){
            listaProductos = productoRepository.findAll();
        } else if (orden.equals("desc")) {
            listaProductos = productoRepository.ordenarPrecio(orden);
        } else if (orden.equals("asc")) {
            listaProductos = productoRepository.ordenarPrecio(orden);
        }else{
            throw new EntityNotFoundException("Solo se acepta ordenar los precios de forma 'desc' o 'asc'");
        }

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
        nuevoProducto.setCreatedAt(LocalDateTime.now());
        nuevoProducto.setUpdatedAt(LocalDateTime.now());
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
        productoEditado.setUpdatedAt(LocalDateTime.now());
        productoRepository.save(productoEditado);
    }


}
