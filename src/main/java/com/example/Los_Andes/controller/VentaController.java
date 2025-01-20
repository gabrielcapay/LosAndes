package com.example.Los_Andes.controller;


import com.example.Los_Andes.dto.VentaDTO;
import com.example.Los_Andes.dto.VentaDetalleDTO;
import com.example.Los_Andes.model.Venta;
import com.example.Los_Andes.model.VentaDetalle;
import com.example.Los_Andes.service.IVentaDetalleService;
import com.example.Los_Andes.service.IVentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class VentaController {

    @Autowired
    private IVentaService ventaService;


    @GetMapping("v1/venta/{id}")
    public VentaDTO buscarUsuario(@PathVariable Long id){
        return ventaService.findVentaByID(id);
    }

    @GetMapping("v1/venta")
    public List<VentaDTO> buscarTodasLasVentas(){
        return ventaService.getVentas();
    }

    @PostMapping("v1/venta/registrar")
    public void registrarVenta(@RequestBody Venta nuevaVenta){
        ventaService.registrarVenta(nuevaVenta);
    }



}
