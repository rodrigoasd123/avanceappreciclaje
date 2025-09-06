package com.upc.avanceappreciclaje.interfaces;

import com.upc.avanceappreciclaje.dto.PuntoAcopioDTO;
import java.util.List;

public interface IPuntoAcopioServices {
    PuntoAcopioDTO crear(PuntoAcopioDTO dto);
    PuntoAcopioDTO actualizar(Long id, PuntoAcopioDTO dto);
    PuntoAcopioDTO obtener(Long id);
    List<PuntoAcopioDTO> listar();
    List<PuntoAcopioDTO> buscarPorUbicacion(String ubicacion);
    void eliminar(Long id);
}