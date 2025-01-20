package com.example.Los_Andes.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;


@Data
@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id_usuario;

    private String nombre_usuario;
    private String apelido_usuario;
    private String correo_usuario;
    private String contrasena_usuario;
    private int telefono_usuario;
    private boolean status_usuario;

    @OneToMany(mappedBy = "vendedor")

    private List<Venta> ventas;

}
