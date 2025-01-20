package com.example.Los_Andes.dto;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
@Data
public class VentaDTO {
    private Long id_venta;
    private float importeTotal_venta;
    private LocalDateTime fecha_venta;

    private List<VentaDetalleDTO> detalles;
}
