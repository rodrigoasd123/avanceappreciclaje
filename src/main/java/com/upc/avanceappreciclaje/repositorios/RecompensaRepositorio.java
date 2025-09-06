package com.upc.avanceappreciclaje.repositorios;

import com.upc.avanceappreciclaje.entidades.Recompensa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecompensaRepositorio extends JpaRepository<Recompensa, Long> {
    List<Recompensa> findByRequisitoLessThanEqual(Integer requisito);
    List<Recompensa> findByRequisitoGreaterThanEqual(Integer requisito);
}