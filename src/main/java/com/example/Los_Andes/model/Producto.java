package com.example.Los_Andes.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id_producto;

    private String nombre_producto;
    private double precio_producto;
    private int stock_producto;
    private Date createdAt;
    private Date updatedAt;

    @ManyToOne
    @JoinColumn(name = "id_ventaDetalle")
    private Categoria categoria_producto;
}
