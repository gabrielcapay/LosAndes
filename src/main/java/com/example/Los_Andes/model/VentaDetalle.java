package com.example.Los_Andes.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class VentaDetalle {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id_ventaDetalle;

    private float precio_ventaDetalle;
    private int cantidad_ventaDetalle;
    private float subtotal_ventaDetalle;

    @ManyToOne
    @JoinColumn(name = "id_venta")
    private Venta venta;
    @OneToOne
    @JoinColumn(name = "id_producto" , referencedColumnName = "id_producto")
    private Producto producto_ventaDetalle;


}
