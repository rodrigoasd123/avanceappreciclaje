package com.upc.avanceappreciclaje.controllers;

import com.upc.avanceappreciclaje.dto.OrganizadorDTO;
import com.upc.avanceappreciclaje.interfaces.IOrganizadorServices;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/organizadores")
public class OrganizadorController {

    private final IOrganizadorServices service;

    public OrganizadorController(IOrganizadorServices service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<OrganizadorDTO> crear(@RequestBody OrganizadorDTO dto) {
        return ResponseEntity.ok(service.crear(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrganizadorDTO> actualizar(@PathVariable Long id, @RequestBody OrganizadorDTO dto) {
        return ResponseEntity.ok(service.actualizar(id, dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrganizadorDTO> obtener(@PathVariable Long id) {
        return ResponseEntity.ok(service.obtener(id));
    }

    @GetMapping
    public ResponseEntity<List<OrganizadorDTO>> listar() {
        return ResponseEntity.ok(service.listar());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}