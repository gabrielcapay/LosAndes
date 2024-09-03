package com.example.Los_Andes.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id_cliente;

    private String nombre_cliente;
    private String apelido_cliente;
    private String correo_cliente;
    private long telefono_cliente;

    @OneToMany(mappedBy = "cliente_venta")
    private List<Venta> compras_cliente;
}
