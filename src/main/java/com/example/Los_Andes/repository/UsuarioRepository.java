package com.example.Los_Andes.repository;

import com.example.Los_Andes.model.Vendedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Vendedor, Long> {
}
