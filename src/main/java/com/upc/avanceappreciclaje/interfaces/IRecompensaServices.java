package com.upc.avanceappreciclaje.interfaces;

import com.upc.avanceappreciclaje.dto.RecompensaDTO;
import java.util.List;

public interface IRecompensaServices {
    RecompensaDTO crear(RecompensaDTO dto);
    RecompensaDTO actualizar(Long id, RecompensaDTO dto);
    RecompensaDTO obtener(Long id);
    List<RecompensaDTO> listar();
    List<RecompensaDTO> obtenerRecompensasDisponibles(Integer puntosUsuario);
    void eliminar(Long id);
}