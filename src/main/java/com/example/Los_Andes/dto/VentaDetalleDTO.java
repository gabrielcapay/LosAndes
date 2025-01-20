package com.example.Los_Andes.dto;

import com.example.Los_Andes.model.Producto;
import lombok.Data;

@Data
public class VentaDetalleDTO {

    private int cantidad_ventaDetalle;
    private float subtotal_ventaDetalle;
    private Producto producto_ventaDetalle;
}
