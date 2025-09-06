package com.upc.avanceappreciclaje.controllers;

import com.upc.avanceappreciclaje.dto.RecompensaDTO;
import com.upc.avanceappreciclaje.interfaces.IRecompensaServices;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recompensas")
public class RecompensaController {

    private final IRecompensaServices service;

    public RecompensaController(IRecompensaServices service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<RecompensaDTO> crear(@RequestBody RecompensaDTO dto) {
        return ResponseEntity.ok(service.crear(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<RecompensaDTO> actualizar(@PathVariable Long id, @RequestBody RecompensaDTO dto) {
        return ResponseEntity.ok(service.actualizar(id, dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<RecompensaDTO> obtener(@PathVariable Long id) {
        return ResponseEntity.ok(service.obtener(id));
    }

    @GetMapping
    public ResponseEntity<List<RecompensaDTO>> listar() {
        return ResponseEntity.ok(service.listar());
    }

    @GetMapping("/disponibles/{puntosUsuario}")
    public ResponseEntity<List<RecompensaDTO>> obtenerRecompensasDisponibles(@PathVariable Integer puntosUsuario) {
        return ResponseEntity.ok(service.obtenerRecompensasDisponibles(puntosUsuario));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}