package com.upc.avanceappreciclaje.controllers;

import com.upc.avanceappreciclaje.dto.EventoDTO;
import com.upc.avanceappreciclaje.interfaces.IEventoServices;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/eventos")
public class EventoController {

    private final IEventoServices service;

    public EventoController(IEventoServices service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<EventoDTO> crear(@RequestBody EventoDTO dto) {
        return ResponseEntity.ok(service.crear(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EventoDTO> actualizar(@PathVariable Long id, @RequestBody EventoDTO dto) {
        return ResponseEntity.ok(service.actualizar(id, dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EventoDTO> obtener(@PathVariable Long id) {
        return ResponseEntity.ok(service.obtener(id));
    }

    @GetMapping
    public ResponseEntity<List<EventoDTO>> listar() {
        return ResponseEntity.ok(service.listar());
    }

    @GetMapping("/organizador/{idOrganizador}")
    public ResponseEntity<List<EventoDTO>> listarPorOrganizador(@PathVariable Long idOrganizador) {
        return ResponseEntity.ok(service.listarPorOrganizador(idOrganizador));
    }

    @GetMapping("/proximos")
    public ResponseEntity<List<EventoDTO>> listarEventosProximos() {
        return ResponseEntity.ok(service.listarEventosProximos());
    }

    @GetMapping("/buscar")
    public ResponseEntity<List<EventoDTO>> buscarPorNombre(@RequestParam String nombre) {
        return ResponseEntity.ok(service.buscarPorNombre(nombre));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}