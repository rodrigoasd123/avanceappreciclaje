package com.upc.avanceappreciclaje.interfaces;

import com.upc.avanceappreciclaje.dto.EventoDTO;
import java.time.LocalDate;
import java.util.List;

public interface IEventoServices {
    EventoDTO crear(EventoDTO dto);
    EventoDTO actualizar(Long id, EventoDTO dto);
    EventoDTO obtener(Long id);
    List<EventoDTO> listar();
    List<EventoDTO> listarPorOrganizador(Long idOrganizador);
    List<EventoDTO> listarEventosProximos();
    List<EventoDTO> buscarPorNombre(String nombre);
    void eliminar(Long id);
}