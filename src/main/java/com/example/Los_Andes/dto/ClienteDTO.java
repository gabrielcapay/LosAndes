package com.example.Los_Andes.dto;

import lombok.Data;

@Data
public class ClienteDTO {
    private Long id_cliente;
    private String nombre_cliente;
    private String apelido_cliente;
    private String correo_cliente;
    private long telefono_cliente;

}
