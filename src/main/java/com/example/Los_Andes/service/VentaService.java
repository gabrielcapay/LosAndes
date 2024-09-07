package com.example.Los_Andes.service;

import com.example.Los_Andes.model.Cliente;
import com.example.Los_Andes.model.Venta;
import com.example.Los_Andes.repository.VentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VentaService implements IVentaService{

    @Autowired
    private VentaRepository ventaRepository;
    @Override
    public List<Venta> getVentas() {
        return ventaRepository.findAll();
    }

    @Override
    public Venta findVentaByID(Long id) {
        return ventaRepository.findById(id).orElse(null);
    }

    @Override
    public void saveVenta(Venta nuevaVenta) {
        ventaRepository.save(nuevaVenta);
    }

    @Override
    public void deleteVenta(Long id) {
        ventaRepository.deleteById(id);
    }
}
