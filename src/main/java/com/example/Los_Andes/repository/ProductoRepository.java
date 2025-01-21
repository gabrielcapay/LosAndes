package com.example.Los_Andes.repository;

import com.example.Los_Andes.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {

    @Query("SELECT p FROM Producto p ORDER BY " +
            "CASE WHEN :priceOrder = 'asc' THEN p.precio_producto END ASC, " +
            "CASE WHEN :priceOrder = 'desc' THEN p.precio_producto END DESC")
    List<Producto> ordenarPrecio(
                @Param("priceOrder") String priceOrder);



}
