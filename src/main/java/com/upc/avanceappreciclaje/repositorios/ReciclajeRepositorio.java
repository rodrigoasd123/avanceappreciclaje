package com.upc.avanceappreciclaje.repositorios;

import com.upc.avanceappreciclaje.entidades.Reciclaje;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReciclajeRepositorio extends JpaRepository<Reciclaje, Long> {
    List<Reciclaje> findByIdUsuario(Long idUsuario);
}
