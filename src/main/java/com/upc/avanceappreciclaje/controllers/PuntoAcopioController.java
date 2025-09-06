package com.upc.avanceappreciclaje.controllers;

import com.upc.avanceappreciclaje.dto.PuntoAcopioDTO;
import com.upc.avanceappreciclaje.interfaces.IPuntoAcopioServices;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/puntos-acopio")
public class PuntoAcopioController {

    private final IPuntoAcopioServices service;

    public PuntoAcopioController(IPuntoAcopioServices service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<PuntoAcopioDTO> crear(@RequestBody PuntoAcopioDTO dto) {
        return ResponseEntity.ok(service.crear(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PuntoAcopioDTO> actualizar(@PathVariable Long id, @RequestBody PuntoAcopioDTO dto) {
        return ResponseEntity.ok(service.actualizar(id, dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PuntoAcopioDTO> obtener(@PathVariable Long id) {
        return ResponseEntity.ok(service.obtener(id));
    }

    @GetMapping
    public ResponseEntity<List<PuntoAcopioDTO>> listar() {
        return ResponseEntity.ok(service.listar());
    }

    @GetMapping("/buscar")
    public ResponseEntity<List<PuntoAcopioDTO>> buscarPorUbicacion(@RequestParam String ubicacion) {
        return ResponseEntity.ok(service.buscarPorUbicacion(ubicacion));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}