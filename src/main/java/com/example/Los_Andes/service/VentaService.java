package com.example.Los_Andes.service;

import com.example.Los_Andes.dto.VentaDTO;
import com.example.Los_Andes.model.Cliente;
import com.example.Los_Andes.model.Venta;
import com.example.Los_Andes.model.VentaDetalle;
import com.example.Los_Andes.repository.VentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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
        if (nuevaVenta.getDetalles_venta() != null) {
            for (VentaDetalle detalle : nuevaVenta.getDetalles_venta()) {
                detalle.setVenta(nuevaVenta); // Establecer la relación bidireccional
            }
        }

        // Guardar la venta y, por cascada, los detalles
        ventaRepository.save(nuevaVenta);
    }

    @Override
    public Venta registrarVenta(VentaDTO ventaDTO) {
        /*Venta venta = new Venta();
        venta.setFecha(ventaDTO.getFecha());

        Set<Detalle> detalles = ventaDTO.getDetalles().stream().map(detalleDTO -> {
            Detalle detalle = new Detalle();
            detalle.setProductoId(detalleDTO.getProductoId());
            detalle.setCantidad(detalleDTO.getCantidad());
            detalle.setPrecio(detalleDTO.getPrecio());
            detalle.setVenta(venta);
            return detalle;
        }).collect(Collectors.toSet());

        venta.setDetalles(detalles);
        return ventaRepository.save(venta);*/

        Venta venta = new Venta();
        venta.setImporteTotal_venta(ventaDTO.getImporteTotal_venta());
        List<VentaDetalle> detalles = ventaDTO.getDetalles_venta().stream().map( detalleDTO ->{
            VentaDetalle detalle = new VentaDetalle();
            detalle.setCantidad_ventaDetalle(detalleDTO.getCantidad_ventaDetalle());
            detalle.setPrecio_ventaDetalle(detalleDTO.getPrecio_ventaDetalle());
            detalle.setSubtotal_ventaDetalle(detalleDTO.getSubtotal_ventaDetalle());
            detalle.setVenta(venta);
            return detalle;

        }).toList();
        venta.setDetalles_venta(detalles);
        return ventaRepository.save(venta);

    }

    @Override
    public void deleteVenta(Long id) {
        ventaRepository.deleteById(id);
    }
}
