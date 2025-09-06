package com.upc.avanceappreciclaje.interfaces;

import com.upc.avanceappreciclaje.dto.MaterialReciclajeDTO;
import java.util.List;

public interface IMaterialReciclajeServices {
    MaterialReciclajeDTO crear(MaterialReciclajeDTO dto);
    MaterialReciclajeDTO actualizar(Long id, MaterialReciclajeDTO dto);
    MaterialReciclajeDTO obtener(Long id);
    List<MaterialReciclajeDTO> listar();
    List<MaterialReciclajeDTO> buscarPorNombre(String nombre);
    void eliminar(Long id);
}