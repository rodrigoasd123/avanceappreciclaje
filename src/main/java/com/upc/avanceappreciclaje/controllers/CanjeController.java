package com.upc.avanceappreciclaje.controllers;

import com.upc.avanceappreciclaje.dto.CanjeDTO;
import com.upc.avanceappreciclaje.interfaces.ICanjeServices;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/canjes")
public class CanjeController {

    private final ICanjeServices service;

    public CanjeController(ICanjeServices service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<CanjeDTO> crear(@RequestBody CanjeDTO dto) {
        return ResponseEntity.ok(service.crear(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CanjeDTO> actualizar(@PathVariable Long id, @RequestBody CanjeDTO dto) {
        return ResponseEntity.ok(service.actualizar(id, dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CanjeDTO> obtener(@PathVariable Long id) {
        return ResponseEntity.ok(service.obtener(id));
    }

    @GetMapping
    public ResponseEntity<List<CanjeDTO>> listar() {
        return ResponseEntity.ok(service.listar());
    }

    @GetMapping("/usuario/{idUsuario}")
    public ResponseEntity<List<CanjeDTO>> listarPorUsuario(@PathVariable Long idUsuario) {
        return ResponseEntity.ok(service.listarPorUsuario(idUsuario));
    }

    @GetMapping("/recompensa/{idRecompensa}")
    public ResponseEntity<List<CanjeDTO>> listarPorRecompensa(@PathVariable Long idRecompensa) {
        return ResponseEntity.ok(service.listarPorRecompensa(idRecompensa));
    }

    @GetMapping("/fecha")
    public ResponseEntity<List<CanjeDTO>> listarPorFecha(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaInicio,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaFin) {
        return ResponseEntity.ok(service.listarPorFecha(fechaInicio, fechaFin));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}