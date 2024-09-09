package com.example.Los_Andes.model;

import ch.qos.logback.core.net.server.Client;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
public class Venta {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)

    private Long id_venta;

    private float importeTotal_venta;
    private LocalDateTime fecha_venta;

    @OneToMany(mappedBy = "venta", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<VentaDetalle> detalles_venta;

    @ManyToOne
    @JoinColumn(name ="id_usuario")
    private Usuario vendedor;

    @ManyToOne
    @JoinColumn(name ="id_cliente" )
    private Cliente cliente_venta;
}
