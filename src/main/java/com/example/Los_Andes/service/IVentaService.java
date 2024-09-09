package com.example.Los_Andes.service;


import com.example.Los_Andes.dto.VentaDTO;
import com.example.Los_Andes.model.Venta;

import java.util.List;

public interface IVentaService {

    public List<Venta> getVentas();
    public Venta findVentaByID(Long id);
    public void saveVenta(Venta nuevaVenta);
    public Venta registrarVenta(VentaDTO ventaDTO);
    public void deleteVenta(Long id);

}
