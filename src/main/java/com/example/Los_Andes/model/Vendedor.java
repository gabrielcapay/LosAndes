package com.example.Los_Andes.model;


import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;


@Data
@Entity
public class Vendedor {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id_vendedor;

    private String nombre_vendedor;
    private String apelido_vendedor;
    private String correo_vendedor;
    private String contrasena_vendedor;
    private int telefono_vendedor;
    private boolean status_vendedor;
    @Column(updatable = false)
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "vendedor")

    private List<Venta> ventas;

}
