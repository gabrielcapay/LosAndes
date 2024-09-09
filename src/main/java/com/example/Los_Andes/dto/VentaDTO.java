package com.example.Los_Andes.dto;

import com.example.Los_Andes.model.VentaDetalle;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class VentaDTO {

    private float importeTotal_venta;
    private LocalDateTime fecha_venta;
    private List<VentaDetalle> detalles_venta;
}
