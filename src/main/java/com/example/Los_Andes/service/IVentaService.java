package com.example.Los_Andes.service;


import com.example.Los_Andes.dto.VentaDTO;
import com.example.Los_Andes.model.Venta;

import java.util.List;

public interface IVentaService {

    public List<VentaDTO> getVentas();
    public VentaDTO findVentaByID(Long id);

    public void registrarVenta(Venta nuevaVenta);

    public void deleteVenta(Long id);

}
