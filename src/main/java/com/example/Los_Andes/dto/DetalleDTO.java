package com.example.Los_Andes.dto;

import com.example.Los_Andes.model.Venta;
import com.example.Los_Andes.model.VentaDetalle;
import lombok.Data;

import java.util.List;

@Data
public class DetalleDTO {
    private float precio_ventaDetalle;
    private int cantidad_ventaDetalle;
    private float subtotal_ventaDetalle;
    private Venta venta;
}
