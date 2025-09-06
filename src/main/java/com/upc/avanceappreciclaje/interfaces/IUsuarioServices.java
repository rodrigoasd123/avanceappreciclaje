package com.upc.avanceappreciclaje.interfaces;

import com.upc.avanceappreciclaje.dto.UsuarioDTO;
import java.util.List;

public interface IUsuarioServices {
    UsuarioDTO crear(UsuarioDTO dto);
    UsuarioDTO actualizar(Long id, UsuarioDTO dto);
    UsuarioDTO obtener(Long id);
    List<UsuarioDTO> listar();
    void eliminar(Long id);
}
