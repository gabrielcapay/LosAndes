package com.example.Los_Andes.dto;

import lombok.Data;

@Data
public class ProductoDTO {
    private Long id_producto;

    private String nombre_producto;
    private double precio_producto;
    private int stock_producto;
    private String categoria_producto;
}
