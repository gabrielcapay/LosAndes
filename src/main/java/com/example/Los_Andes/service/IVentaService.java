package com.example.Los_Andes.service;


import com.example.Los_Andes.dto.VentaDTO;
import com.example.Los_Andes.model.Venta;

import java.util.List;

public interface IVentaService {

    public List<Venta> getVentas();
    public Venta findVentaByID(Long id);

    public void registrarVenta(Venta nuevaVenta);

    public void deleteVenta(Long id);

}
