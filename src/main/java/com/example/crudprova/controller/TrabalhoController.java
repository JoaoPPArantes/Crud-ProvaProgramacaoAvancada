package com.example.crudprova.controller;


import com.example.crudprova.dto.TrabalhoDTO;
import com.example.crudprova.service.TrabalhoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/trabalhos")
public class TrabalhoController {
    @Autowired
    private TrabalhoService trabalhoService;

    @PostMapping
    public ResponseEntity<TrabalhoDTO> criar(@RequestBody TrabalhoDTO dto) {
        return ResponseEntity.status(201).body(trabalhoService.salvar(dto));
    }

    @GetMapping
    public ResponseEntity<List<TrabalhoDTO>> listar() {
        return ResponseEntity.ok(trabalhoService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TrabalhoDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(trabalhoService.buscarPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TrabalhoDTO> atualizar(@PathVariable Long id, @RequestBody TrabalhoDTO dto) {
        return ResponseEntity.ok(trabalhoService.atualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        trabalhoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
