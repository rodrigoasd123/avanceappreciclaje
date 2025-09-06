package com.upc.avanceappreciclaje.interfaces;

import com.upc.avanceappreciclaje.dto.OrganizadorDTO;
import java.util.List;

public interface IOrganizadorServices {
    OrganizadorDTO crear(OrganizadorDTO dto);
    OrganizadorDTO actualizar(Long id, OrganizadorDTO dto);
    OrganizadorDTO obtener(Long id);
    List<OrganizadorDTO> listar();
    void eliminar(Long id);
}