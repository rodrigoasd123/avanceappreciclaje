package com.upc.avanceappreciclaje.services;

import com.upc.avanceappreciclaje.dto.CanjeDTO;
import com.upc.avanceappreciclaje.entidades.Canje;
import com.upc.avanceappreciclaje.interfaces.ICanjeServices;
import com.upc.avanceappreciclaje.repositorios.CanjeRepositorio;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class CanjeService implements ICanjeServices {

    private final CanjeRepositorio repo;
    private final ModelMapper mapper;

    public CanjeService(CanjeRepositorio repo, ModelMapper mapper) {
        this.repo = repo;
        this.mapper = mapper;
    }

    @Override
    public CanjeDTO crear(CanjeDTO dto) {
        Canje entity = mapper.map(dto, Canje.class);
        entity.setIdCanje(null);
        // Establecer fecha actual si no se proporciona
        if (entity.getFecha() == null) {
            entity.setFecha(LocalDate.now());
        }
        Canje savedEntity = repo.save(entity);
        return mapper.map(savedEntity, CanjeDTO.class);
    }

    @Override
    public CanjeDTO actualizar(Long id, CanjeDTO dto) {
        Canje entity = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Canje no encontrado"));

        entity.setFecha(dto.getFecha());
        entity.setCosto(dto.getCosto());
        entity.setIdUsuario(dto.getIdUsuario());
        entity.setIdRecompensa(dto.getIdRecompensa());

        Canje updatedEntity = repo.save(entity);
        return mapper.map(updatedEntity, CanjeDTO.class);
    }

    @Override
    public CanjeDTO obtener(Long id) {
        Canje entity = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Canje no encontrado"));
        return mapper.map(entity, CanjeDTO.class);
    }

    @Override
    public List<CanjeDTO> listar() {
        return repo.findAll().stream()
                .map(e -> mapper.map(e, CanjeDTO.class))
                .toList();
    }

    @Override
    public List<CanjeDTO> listarPorUsuario(Long idUsuario) {
        return repo.findByIdUsuario(idUsuario).stream()
                .map(e -> mapper.map(e, CanjeDTO.class))
                .toList();
    }

    @Override
    public List<CanjeDTO> listarPorRecompensa(Long idRecompensa) {
        return repo.findByIdRecompensa(idRecompensa).stream()
                .map(e -> mapper.map(e, CanjeDTO.class))
                .toList();
    }

    @Override
    public List<CanjeDTO> listarPorFecha(LocalDate fechaInicio, LocalDate fechaFin) {
        return repo.findByFechaBetween(fechaInicio, fechaFin).stream()
                .map(e -> mapper.map(e, CanjeDTO.class))
                .toList();
    }

    @Override
    public void eliminar(Long id) {
        if (!repo.existsById(id)) {
            throw new RuntimeException("Canje no encontrado");
        }
        repo.deleteById(id);
    }
}