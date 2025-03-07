package com.VilmarPrestes.crud_escolar.controllers;

import com.VilmarPrestes.crud_escolar.dto.CursoDTO;
import com.VilmarPrestes.crud_escolar.model.Curso;
import com.VilmarPrestes.crud_escolar.service.CursoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cursos")
@CrossOrigin(origins = "http://localhost:4200")
public class CursoController {

    private final CursoService cursoService;

    public CursoController(CursoService cursoService) {
        this.cursoService = cursoService;
    }

    @GetMapping
    public ResponseEntity<List<CursoDTO>> listarTodos() {
        return ResponseEntity.ok(cursoService.getAll());
    }

    @PostMapping
    public ResponseEntity<CursoDTO> criar(@Valid @RequestBody CursoDTO cursoDTO) {
        return ResponseEntity.ok(cursoService.save(cursoDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CursoDTO> atualizar(@PathVariable Long id, @Valid @RequestBody CursoDTO cursoDTO) {
        return ResponseEntity.ok(cursoService.update(id, cursoDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        cursoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
