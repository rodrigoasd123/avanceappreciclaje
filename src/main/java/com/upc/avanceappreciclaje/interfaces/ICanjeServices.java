package com.upc.avanceappreciclaje.interfaces;

import com.upc.avanceappreciclaje.dto.CanjeDTO;
import java.time.LocalDate;
import java.util.List;

public interface ICanjeServices {
    CanjeDTO crear(CanjeDTO dto);
    CanjeDTO actualizar(Long id, CanjeDTO dto);
    CanjeDTO obtener(Long id);
    List<CanjeDTO> listar();
    List<CanjeDTO> listarPorUsuario(Long idUsuario);
    List<CanjeDTO> listarPorRecompensa(Long idRecompensa);
    List<CanjeDTO> listarPorFecha(LocalDate fechaInicio, LocalDate fechaFin);
    void eliminar(Long id);
}