package com.example.Los_Andes.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id_producto;

    private String nombre_producto;
    private double precio_producto;
    private int stock_producto;

    @OneToOne
    @JoinColumn(name = "id_categoria" , referencedColumnName = "id_categoria")
    private Categoria categoria_producto;
}
