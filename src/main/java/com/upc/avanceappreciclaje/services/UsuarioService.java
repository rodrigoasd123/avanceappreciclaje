package com.upc.avanceappreciclaje.services;

import com.upc.avanceappreciclaje.dto.UsuarioDTO;
import com.upc.avanceappreciclaje.entidades.Usuario;
import com.upc.avanceappreciclaje.interfaces.IUsuarioServices;
import com.upc.avanceappreciclaje.repositorios.UsuarioRepositorio;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService implements IUsuarioServices {

    private final UsuarioRepositorio repo;
    private final ModelMapper mapper;

    public UsuarioService(UsuarioRepositorio repo, ModelMapper mapper) {
        this.repo = repo;
        this.mapper = mapper;
    }

    @Override
    public UsuarioDTO crear(UsuarioDTO dto) {
        Usuario entity = mapper.map(dto, Usuario.class);
        entity.setIdUsuario(null);
        return mapper.map(repo.save(entity), UsuarioDTO.class);
    }

    @Override
    public UsuarioDTO actualizar(Long id, UsuarioDTO dto) {
        Usuario entity = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        // Solo campos editables:
        entity.setNombre(dto.getNombre());
        entity.setApellido(dto.getApellido());
        entity.setCorreo(dto.getCorreo());
        entity.setPesoRecolectado(dto.getPesoRecolectado());
        entity.setPuntos(dto.getPuntos());
        return mapper.map(repo.save(entity), UsuarioDTO.class);
    }

    @Override
    public UsuarioDTO obtener(Long id) {
        Usuario entity = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        return mapper.map(entity, UsuarioDTO.class);
    }

    @Override
    public List<UsuarioDTO> listar() {
        return repo.findAll().stream()
                .map(e -> mapper.map(e, UsuarioDTO.class))
                .toList();
    }

    @Override
    public void eliminar(Long id) {
        repo.deleteById(id);
    }
}
