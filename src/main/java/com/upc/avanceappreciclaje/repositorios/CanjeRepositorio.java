package com.upc.avanceappreciclaje.repositorios;

import com.upc.avanceappreciclaje.entidades.Canje;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface CanjeRepositorio extends JpaRepository<Canje, Long> {
    List<Canje> findByIdUsuario(Long idUsuario);
    List<Canje> findByIdRecompensa(Long idRecompensa);
    List<Canje> findByFechaBetween(LocalDate fechaInicio, LocalDate fechaFin);
}