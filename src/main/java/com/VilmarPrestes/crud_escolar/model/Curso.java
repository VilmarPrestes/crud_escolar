package com.VilmarPrestes.crud_escolar.model;

import com.VilmarPrestes.crud_escolar.dto.CursoDTO;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "cursos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private LocalDateTime inicioAulas;
    private LocalDateTime fimAulas;
    private Boolean ativo;

    public Curso(CursoDTO cursoDTO) {
        this.nome = cursoDTO.getNome();
        this.inicioAulas = cursoDTO.getInicioAulas();
        this.fimAulas = cursoDTO.getFimAulas();
        this.ativo = cursoDTO.getAtivo();
    }

    public void updateFromDTO(CursoDTO cursoDTO) {
        this.nome = cursoDTO.getNome();
        this.inicioAulas = cursoDTO.getInicioAulas();
        this.fimAulas = cursoDTO.getFimAulas();
        this.ativo = cursoDTO.getAtivo();
    }
}
