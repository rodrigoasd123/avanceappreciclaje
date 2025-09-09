package com.upc.avanceappreciclaje.services;

import com.upc.avanceappreciclaje.dto.EventoDTO;
import com.upc.avanceappreciclaje.entidades.Evento;
import com.upc.avanceappreciclaje.interfaces.IEventoServices;
import com.upc.avanceappreciclaje.repositorios.EventoRepositorio;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class EventoService implements IEventoServices {

    private final EventoRepositorio repo;
    private final ModelMapper mapper;

    public EventoService(EventoRepositorio repo, ModelMapper mapper) {
        this.repo = repo;
        this.mapper = mapper;
    }

    @Override
    public EventoDTO crear(EventoDTO dto) {
        Evento entity = mapper.map(dto, Evento.class);
        entity.setIdEvento(null);
        Evento savedEntity = repo.save(entity);
        return mapper.map(savedEntity, EventoDTO.class);
    }

    @Override
    public EventoDTO actualizar(Long id, EventoDTO dto) {
        Evento entity = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Evento no encontrado"));

        entity.setNombre(dto.getNombre());
        entity.setFecha(dto.getFecha());
        entity.setHora(dto.getHora());
        entity.setLugar(dto.getLugar());
        entity.setDescripcion(dto.getDescripcion());
        entity.setIdOrganizador(dto.getIdOrganizador());

        Evento updatedEntity = repo.save(entity);
        return mapper.map(updatedEntity, EventoDTO.class);
    }

    @Override
    public EventoDTO obtener(Long id) {
        Evento entity = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Evento no encontrado"));
        return mapper.map(entity, EventoDTO.class);
    }

    @Override
    public List<EventoDTO> listar() {
        return repo.findAll().stream()
                .map(e -> mapper.map(e, EventoDTO.class))
                .toList();
    }

    @Override
    public List<EventoDTO> listarPorOrganizador(Long idOrganizador) {
        return repo.findByIdOrganizador(idOrganizador).stream()
                .map(e -> mapper.map(e, EventoDTO.class))
                .toList();
    }

    @Override
    public List<EventoDTO> listarEventosProximos() {
        LocalDate hoy = LocalDate.now();
        return repo.findByFechaAfter(hoy).stream()
                .map(e -> mapper.map(e, EventoDTO.class))
                .toList();
    }

    @Override
    public List<EventoDTO> buscarPorNombre(String nombre) {
        return repo.findByNombreContainingIgnoreCase(nombre).stream()
                .map(e -> mapper.map(e, EventoDTO.class))
                .toList();
    }

    @Override
    public void eliminar(Long id) {
        if (!repo.existsById(id)) {
            throw new RuntimeException("Evento no encontrado");
        }
        repo.deleteById(id);
    }
}