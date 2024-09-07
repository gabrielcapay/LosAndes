package com.example.Los_Andes.repository;

import com.example.Los_Andes.model.VentaDetalle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.awt.*;

@Repository
public interface VentaDetalleRepository extends JpaRepository<VentaDetalle, Long> {


}
