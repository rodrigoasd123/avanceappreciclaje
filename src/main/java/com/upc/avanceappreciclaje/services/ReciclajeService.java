package com.upc.avanceappreciclaje.services;

import com.upc.avanceappreciclaje.dto.ReciclajeDTO;
import com.upc.avanceappreciclaje.entidades.Reciclaje;
import com.upc.avanceappreciclaje.interfaces.IReciclajeServices;
import com.upc.avanceappreciclaje.repositorios.ReciclajeRepositorio;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReciclajeService implements IReciclajeServices {

    private final ReciclajeRepositorio repo;
    private final ModelMapper mapper;

    public ReciclajeService(ReciclajeRepositorio repo, ModelMapper mapper) {
        this.repo = repo;
        this.mapper = mapper;
    }

    @Override
    public ReciclajeDTO crear(ReciclajeDTO dto) {
        Reciclaje e = mapper.map(dto, Reciclaje.class);
        e.setIdReciclaje(null);
        return mapper.map(repo.save(e), ReciclajeDTO.class);
    }

    @Override
    public ReciclajeDTO actualizar(Long id, ReciclajeDTO dto) {
        Reciclaje e = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Reciclaje no encontrado"));
        e.setFecha(dto.getFecha());
        e.setHora(dto.getHora());
        e.setPeso(dto.getPeso());
        e.setIdUsuario(dto.getIdUsuario());
        e.setIdMateriales(dto.getIdMateriales());
        e.setIdAcopio(dto.getIdAcopio());
        return mapper.map(repo.save(e), ReciclajeDTO.class);
    }

    @Override
    public ReciclajeDTO obtener(Long id) {
        return repo.findById(id)
                .map(r -> mapper.map(r, ReciclajeDTO.class))
                .orElseThrow(() -> new RuntimeException("Reciclaje no encontrado"));
    }

    @Override
    public List<ReciclajeDTO> listar() {
        return repo.findAll().stream()
                .map(r -> mapper.map(r, ReciclajeDTO.class))
                .toList();
    }

    @Override
    public List<ReciclajeDTO> listarPorUsuario(Long idUsuario) {
        return repo.findByIdUsuario(idUsuario).stream()
                .map(r -> mapper.map(r, ReciclajeDTO.class))
                .toList();
    }

    @Override
    public void eliminar(Long id) {
        repo.deleteById(id);
    }
}
