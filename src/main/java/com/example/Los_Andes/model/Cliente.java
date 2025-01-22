package com.example.Los_Andes.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
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

    private Date createdAt;
    private Date updatedAt;

    @OneToMany(mappedBy = "cliente_venta")

    private List<Venta> compras_cliente;
}
