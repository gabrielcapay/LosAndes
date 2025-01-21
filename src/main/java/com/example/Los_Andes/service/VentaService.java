package com.example.Los_Andes.service;

import com.example.Los_Andes.dto.VentaDTO;
import com.example.Los_Andes.dto.VentaDetalleDTO;
import com.example.Los_Andes.model.Producto;
import com.example.Los_Andes.model.Venta;
import com.example.Los_Andes.model.VentaDetalle;
import com.example.Los_Andes.repository.ProductoRepository;
import com.example.Los_Andes.repository.VentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VentaService implements IVentaService{

    @Autowired
    private VentaRepository ventaRepository;

    @Override
    public List<VentaDTO> getVentas() {
        List<Venta> ventasRealizadas = ventaRepository.findAll();


        List<VentaDTO> ventasReponse = new ArrayList<>();

        for (Venta venta: ventasRealizadas) {
            VentaDTO ventaResponse = new VentaDTO();
            ventaResponse.setImporteTotal_venta(venta.getImporteTotal_venta());
            ventaResponse.setFecha_venta(venta.getFecha_venta());
            ventaResponse.setId_venta(venta.getId_venta());
            List<VentaDetalleDTO> detalles = new ArrayList<>();
            for (VentaDetalle ventaDetalles: venta.getDetalles_venta()) {
                VentaDetalleDTO detalle = new VentaDetalleDTO();
                detalle.setSubtotal(ventaDetalles.getSubtotal_ventaDetalle());
                detalle.setCantidad(ventaDetalles.getCantidad_ventaDetalle());
                detalle.setProducto(ventaDetalles.getProducto_ventaDetalle());
                detalles.add(detalle);
            }
            ventaResponse.setDetalles(detalles);
            ventasReponse.add(ventaResponse);
        }

        return ventasReponse;
    }

    @Override
    public VentaDTO findVentaByID(Long id) {
        Venta venta = ventaRepository.findById(id).orElse(null);
        VentaDTO ventaDTO = new VentaDTO();
        ventaDTO.setId_venta(venta.getId_venta());
        ventaDTO.setImporteTotal_venta(venta.getImporteTotal_venta());

        List<VentaDetalleDTO> detalles = new ArrayList<>();

        for (VentaDetalle ventaDetalle: venta.getDetalles_venta()) {
            VentaDetalleDTO ventaDetalleDTO = new VentaDetalleDTO();
            ventaDetalleDTO.setSubtotal(ventaDetalle.getSubtotal_ventaDetalle());
            ventaDetalleDTO.setCantidad(ventaDetalle.getCantidad_ventaDetalle());
            ventaDetalleDTO.setProducto(ventaDetalle.getProducto_ventaDetalle());

            detalles.add(ventaDetalleDTO);
        }
        ventaDTO.setDetalles(detalles);

        return ventaDTO;
    }

    @Override
    public void registrarVenta(Venta nuevaVenta) {
        if (nuevaVenta.getDetalles_venta() != null) {
            for (VentaDetalle detalle : nuevaVenta.getDetalles_venta()) {
                detalle.setVenta(nuevaVenta);
            }
        }


        ventaRepository.save(nuevaVenta);
    }


    @Override
    public void deleteVenta(Long id) {
        ventaRepository.deleteById(id);
    }
    }



