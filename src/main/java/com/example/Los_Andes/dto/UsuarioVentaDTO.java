package com.example.Los_Andes.dto;

import lombok.Data;

import java.util.List;

@Data
public class UsuarioVentaDTO {
    private Long id_usuario;
    private String nombre_usuario;
    private String apelido_usuario;
    private String correo_usuario;
    private int telefono_usuario;
    private boolean status_usuario;
    private List<VentaDTO> compras;
}

