package com.example.Los_Andes.dto;

import com.example.Los_Andes.model.Producto;
import lombok.Data;

@Data
public class VentaDetalleDTO {

    private int cantidad;
    private float subtotal;
    private Producto producto;
}
