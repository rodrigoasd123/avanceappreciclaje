package com.upc.avanceappreciclaje.interfaces;

import com.upc.avanceappreciclaje.dto.ReciclajeDTO;
import java.util.List;

public interface IReciclajeServices {
    ReciclajeDTO crear(ReciclajeDTO dto);
    ReciclajeDTO actualizar(Long id, ReciclajeDTO dto);
    ReciclajeDTO obtener(Long id);
    List<ReciclajeDTO> listar();
    List<ReciclajeDTO> listarPorUsuario(Long idUsuario);
    void eliminar(Long id);
}
