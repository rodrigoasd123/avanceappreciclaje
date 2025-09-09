package com.upc.avanceappreciclaje.repositorios;

import com.upc.avanceappreciclaje.entidades.Evento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface EventoRepositorio extends JpaRepository<Evento, Long> {
    List<Evento> findByIdOrganizador(Long idOrganizador);
    List<Evento> findByFechaAfter(LocalDate fecha);
    List<Evento> findByFechaBetween(LocalDate fechaInicio, LocalDate fechaFin);
    List<Evento> findByNombreContainingIgnoreCase(String nombre);
}