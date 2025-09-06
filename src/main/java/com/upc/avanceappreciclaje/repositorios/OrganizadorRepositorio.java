package com.upc.avanceappreciclaje.repositorios;

import com.upc.avanceappreciclaje.entidades.Organizador;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OrganizadorRepositorio extends JpaRepository<Organizador, Long> {
    Optional<Organizador> findByNombre(String nombre);
}