package com.example.Los_Andes.service;

import com.example.Los_Andes.model.VentaDetalle;
import com.example.Los_Andes.repository.VentaDetalleRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class VentaDetalleService implements IVentaDetalleService{

    @Autowired
    private VentaDetalleRepository ventaDetalleRepository;

    @Override
    public void saveVentaDetalle(VentaDetalle nuevoDetalle) {
        ventaDetalleRepository.save(nuevoDetalle);
    }
}
