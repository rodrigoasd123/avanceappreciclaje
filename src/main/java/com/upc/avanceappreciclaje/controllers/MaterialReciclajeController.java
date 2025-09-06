package com.upc.avanceappreciclaje.controllers;

import com.upc.avanceappreciclaje.dto.MaterialReciclajeDTO;
import com.upc.avanceappreciclaje.interfaces.IMaterialReciclajeServices;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/materiales")
public class MaterialReciclajeController {

    private final IMaterialReciclajeServices service;

    public MaterialReciclajeController(IMaterialReciclajeServices service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<MaterialReciclajeDTO> crear(@RequestBody MaterialReciclajeDTO dto) {
        return ResponseEntity.ok(service.crear(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MaterialReciclajeDTO> actualizar(@PathVariable Long id, @RequestBody MaterialReciclajeDTO dto) {
        return ResponseEntity.ok(service.actualizar(id, dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<MaterialReciclajeDTO> obtener(@PathVariable Long id) {
        return ResponseEntity.ok(service.obtener(id));
    }

    @GetMapping
    public ResponseEntity<List<MaterialReciclajeDTO>> listar() {
        return ResponseEntity.ok(service.listar());
    }

    @GetMapping("/buscar")
    public ResponseEntity<List<MaterialReciclajeDTO>> buscarPorNombre(@RequestParam String nombre) {
        return ResponseEntity.ok(service.buscarPorNombre(nombre));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}