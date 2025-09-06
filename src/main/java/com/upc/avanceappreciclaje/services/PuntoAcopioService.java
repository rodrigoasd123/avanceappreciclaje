package com.upc.avanceappreciclaje.services;

import com.upc.avanceappreciclaje.dto.PuntoAcopioDTO;
import com.upc.avanceappreciclaje.entidades.PuntoAcopio;
import com.upc.avanceappreciclaje.interfaces.IPuntoAcopioServices;
import com.upc.avanceappreciclaje.repositorios.PuntoAcopioRepositorio;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PuntoAcopioService implements IPuntoAcopioServices {

    private final PuntoAcopioRepositorio repo;
    private final ModelMapper mapper;

    public PuntoAcopioService(PuntoAcopioRepositorio repo, ModelMapper mapper) {
        this.repo = repo;
        this.mapper = mapper;
    }

    @Override
    public PuntoAcopioDTO crear(PuntoAcopioDTO dto) {
        PuntoAcopio entity = mapper.map(dto, PuntoAcopio.class);
        entity.setIdAcopio(null);
        PuntoAcopio savedEntity = repo.save(entity);
        return mapper.map(savedEntity, PuntoAcopioDTO.class);
    }

    @Override
    public PuntoAcopioDTO actualizar(Long id, PuntoAcopioDTO dto) {
        PuntoAcopio entity = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Punto de acopio no encontrado"));

        entity.setNombre(dto.getNombre());
        entity.setUbicacion(dto.getUbicacion());

        PuntoAcopio updatedEntity = repo.save(entity);
        return mapper.map(updatedEntity, PuntoAcopioDTO.class);
    }

    @Override
    public PuntoAcopioDTO obtener(Long id) {
        PuntoAcopio entity = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Punto de acopio no encontrado"));
        return mapper.map(entity, PuntoAcopioDTO.class);
    }

    @Override
    public List<PuntoAcopioDTO> listar() {
        return repo.findAll().stream()
                .map(e -> mapper.map(e, PuntoAcopioDTO.class))
                .toList();
    }

    @Override
    public List<PuntoAcopioDTO> buscarPorUbicacion(String ubicacion) {
        return repo.findByUbicacionContainingIgnoreCase(ubicacion).stream()
                .map(e -> mapper.map(e, PuntoAcopioDTO.class))
                .toList();
    }

    @Override
    public void eliminar(Long id) {
        if (!repo.existsById(id)) {
            throw new RuntimeException("Punto de acopio no encontrado");
        }
        repo.deleteById(id);
    }
}