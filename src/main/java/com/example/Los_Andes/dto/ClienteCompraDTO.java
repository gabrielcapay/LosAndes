package com.example.Los_Andes.dto;

import com.example.Los_Andes.model.Venta;
import lombok.Data;

import java.util.List;


@Data
public class ClienteCompraDTO {
    private Long id_cliente;

    private String nombre_cliente;
    private String apelido_cliente;
    private String correo_cliente;
    private long telefono_cliente;

    private List<Venta> compras_cliente;
}
