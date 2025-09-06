package com.upc.avanceappreciclaje.services;

import com.upc.avanceappreciclaje.dto.MaterialReciclajeDTO;
import com.upc.avanceappreciclaje.entidades.MaterialReciclaje;
import com.upc.avanceappreciclaje.interfaces.IMaterialReciclajeServices;
import com.upc.avanceappreciclaje.repositorios.MaterialReciclajeRepositorio;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaterialReciclajeService implements IMaterialReciclajeServices {

    private final MaterialReciclajeRepositorio repo;
    private final ModelMapper mapper;

    public MaterialReciclajeService(MaterialReciclajeRepositorio repo, ModelMapper mapper) {
        this.repo = repo;
        this.mapper = mapper;
    }

    @Override
    public MaterialReciclajeDTO crear(MaterialReciclajeDTO dto) {
        MaterialReciclaje entity = mapper.map(dto, MaterialReciclaje.class);
        entity.setIdMateriales(null);
        MaterialReciclaje savedEntity = repo.save(entity);
        return mapper.map(savedEntity, MaterialReciclajeDTO.class);
    }

    @Override
    public MaterialReciclajeDTO actualizar(Long id, MaterialReciclajeDTO dto) {
        MaterialReciclaje entity = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Material de reciclaje no encontrado"));

        entity.setNombre(dto.getNombre());
        entity.setDescripcion(dto.getDescripcion());

        MaterialReciclaje updatedEntity = repo.save(entity);
        return mapper.map(updatedEntity, MaterialReciclajeDTO.class);
    }

    @Override
    public MaterialReciclajeDTO obtener(Long id) {
        MaterialReciclaje entity = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Material de reciclaje no encontrado"));
        return mapper.map(entity, MaterialReciclajeDTO.class);
    }

    @Override
    public List<MaterialReciclajeDTO> listar() {
        return repo.findAll().stream()
                .map(e -> mapper.map(e, MaterialReciclajeDTO.class))
                .toList();
    }

    @Override
    public List<MaterialReciclajeDTO> buscarPorNombre(String nombre) {
        return repo.findByNombreContainingIgnoreCase(nombre).stream()
                .map(e -> mapper.map(e, MaterialReciclajeDTO.class))
                .toList();
    }

    @Override
    public void eliminar(Long id) {
        if (!repo.existsById(id)) {
            throw new RuntimeException("Material de reciclaje no encontrado");
        }
        repo.deleteById(id);
    }
}