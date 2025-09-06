package com.upc.avanceappreciclaje.services;

import com.upc.avanceappreciclaje.dto.RecompensaDTO;
import com.upc.avanceappreciclaje.entidades.Recompensa;
import com.upc.avanceappreciclaje.interfaces.IRecompensaServices;
import com.upc.avanceappreciclaje.repositorios.RecompensaRepositorio;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecompensaService implements IRecompensaServices {

    private final RecompensaRepositorio repo;
    private final ModelMapper mapper;

    public RecompensaService(RecompensaRepositorio repo, ModelMapper mapper) {
        this.repo = repo;
        this.mapper = mapper;
    }

    @Override
    public RecompensaDTO crear(RecompensaDTO dto) {
        Recompensa entity = mapper.map(dto, Recompensa.class);
        entity.setIdRecompensa(null);
        Recompensa savedEntity = repo.save(entity);
        return mapper.map(savedEntity, RecompensaDTO.class);
    }

    @Override
    public RecompensaDTO actualizar(Long id, RecompensaDTO dto) {
        Recompensa entity = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Recompensa no encontrada"));

        entity.setDescripcion(dto.getDescripcion());
        entity.setRequisito(dto.getRequisito());

        Recompensa updatedEntity = repo.save(entity);
        return mapper.map(updatedEntity, RecompensaDTO.class);
    }

    @Override
    public RecompensaDTO obtener(Long id) {
        Recompensa entity = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Recompensa no encontrada"));
        return mapper.map(entity, RecompensaDTO.class);
    }

    @Override
    public List<RecompensaDTO> listar() {
        return repo.findAll().stream()
                .map(e -> mapper.map(e, RecompensaDTO.class))
                .toList();
    }

    @Override
    public List<RecompensaDTO> obtenerRecompensasDisponibles(Integer puntosUsuario) {
        return repo.findByRequisitoLessThanEqual(puntosUsuario).stream()
                .map(e -> mapper.map(e, RecompensaDTO.class))
                .toList();
    }

    @Override
    public void eliminar(Long id) {
        if (!repo.existsById(id)) {
            throw new RuntimeException("Recompensa no encontrada");
        }
        repo.deleteById(id);
    }
}