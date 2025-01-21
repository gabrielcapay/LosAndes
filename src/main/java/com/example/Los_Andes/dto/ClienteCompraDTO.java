package com.example.Los_Andes.dto;

import com.example.Los_Andes.model.Venta;
import lombok.Data;

import java.util.List;


@Data
public class ClienteCompraDTO {
    private Long id_cliente;

    private String nombre;
    private String apellido;
    private String correo;
    private long telefono;

    private List<CompraDTO> compras;
}
