package com.example.Los_Andes.controller;

import com.example.Los_Andes.dto.VentaDTO;
import com.example.Los_Andes.model.Usuario;
import com.example.Los_Andes.model.Venta;
import com.example.Los_Andes.service.IVentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VentaController {

    @Autowired
    private IVentaService ventaService;

    @GetMapping("v1/venta/{id}")
    public Venta buscarUsuario(@PathVariable Long id){
        return ventaService.findVentaByID(id);
    }

    @GetMapping("v1/venta/listar")
    public List<Venta> buscarTodasLasVentas(){
        return ventaService.getVentas();
    }

    @PostMapping("v1/venta/registrarr")
    public void registrarVenta(@RequestBody Venta nuevaVenta){
        ventaService.saveVenta(nuevaVenta);
    }

    @PostMapping("v1/venta/registrar")
    public void registrarVenta(@RequestBody VentaDTO nuevaVenta){
        ventaService.registrarVenta(nuevaVenta);
    }

    @PutMapping("v1/venta/editar")
    public void editarVenta(@RequestBody Venta venta){ //implementar
    }





}
