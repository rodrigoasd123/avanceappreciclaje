package com.upc.avanceappreciclaje.repositorios;

import com.upc.avanceappreciclaje.entidades.MaterialReciclaje;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MaterialReciclajeRepositorio extends JpaRepository<MaterialReciclaje, Long> {
    Optional<MaterialReciclaje> findByNombre(String nombre);
    List<MaterialReciclaje> findByNombreContainingIgnoreCase(String nombre);
}