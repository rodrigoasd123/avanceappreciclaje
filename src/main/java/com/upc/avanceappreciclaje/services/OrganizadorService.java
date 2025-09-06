package com.upc.avanceappreciclaje.services;

import com.upc.avanceappreciclaje.dto.OrganizadorDTO;
import com.upc.avanceappreciclaje.entidades.Organizador;
import com.upc.avanceappreciclaje.interfaces.IOrganizadorServices;
import com.upc.avanceappreciclaje.repositorios.OrganizadorRepositorio;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrganizadorService implements IOrganizadorServices {

    private final OrganizadorRepositorio repo;
    private final ModelMapper mapper;

    public OrganizadorService(OrganizadorRepositorio repo, ModelMapper mapper) {
        this.repo = repo;
        this.mapper = mapper;
    }

    @Override
    public OrganizadorDTO crear(OrganizadorDTO dto) {
        Organizador entity = mapper.map(dto, Organizador.class);
        entity.setIdOrganizador(null);
        Organizador savedEntity = repo.save(entity);
        return mapper.map(savedEntity, OrganizadorDTO.class);
    }

    @Override
    public OrganizadorDTO actualizar(Long id, OrganizadorDTO dto) {
        Organizador entity = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Organizador no encontrado"));

        entity.setNombre(dto.getNombre());

        Organizador updatedEntity = repo.save(entity);
        return mapper.map(updatedEntity, OrganizadorDTO.class);
    }

    @Override
    public OrganizadorDTO obtener(Long id) {
        Organizador entity = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Organizador no encontrado"));
        return mapper.map(entity, OrganizadorDTO.class);
    }

    @Override
    public List<OrganizadorDTO> listar() {
        return repo.findAll().stream()
                .map(e -> mapper.map(e, OrganizadorDTO.class))
                .toList();
    }

    @Override
    public void eliminar(Long id) {
        if (!repo.existsById(id)) {
            throw new RuntimeException("Organizador no encontrado");
        }
        repo.deleteById(id);
    }
}