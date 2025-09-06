package com.upc.avanceappreciclaje.repositorios;

import com.upc.avanceappreciclaje.entidades.PuntoAcopio;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PuntoAcopioRepositorio extends JpaRepository<PuntoAcopio, Long> {
    Optional<PuntoAcopio> findByNombre(String nombre);
    List<PuntoAcopio> findByUbicacionContainingIgnoreCase(String ubicacion);
}