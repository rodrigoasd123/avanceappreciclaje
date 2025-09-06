package com.upc.avanceappreciclaje.controllers;

import com.upc.avanceappreciclaje.dto.ReciclajeDTO;
import com.upc.avanceappreciclaje.interfaces.IReciclajeServices;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reciclajes")
public class ReciclajeController {

    private final IReciclajeServices service;

    public ReciclajeController(IReciclajeServices service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<ReciclajeDTO> crear(@RequestBody ReciclajeDTO dto){
        return ResponseEntity.ok(service.crear(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ReciclajeDTO> actualizar(@PathVariable Long id, @RequestBody ReciclajeDTO dto){
        return ResponseEntity.ok(service.actualizar(id, dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReciclajeDTO> obtener(@PathVariable Long id){
        return ResponseEntity.ok(service.obtener(id));
    }

    @GetMapping
    public ResponseEntity<List<ReciclajeDTO>> listar(){
        return ResponseEntity.ok(service.listar());
    }

    @GetMapping("/usuario/{idUsuario}")
    public ResponseEntity<List<ReciclajeDTO>> listarPorUsuario(@PathVariable Long idUsuario){
        return ResponseEntity.ok(service.listarPorUsuario(idUsuario));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id){
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
