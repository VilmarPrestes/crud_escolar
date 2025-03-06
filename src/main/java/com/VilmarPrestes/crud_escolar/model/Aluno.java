package com.VilmarPrestes.crud_escolar.model;

import com.VilmarPrestes.crud_escolar.dto.AlunoDTO;
import com.VilmarPrestes.crud_escolar.enums.EnumSituacao;
import com.VilmarPrestes.crud_escolar.repository.CursoRepository;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "alunos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private LocalDate dataNascimento;
    private String cpf;

    @Enumerated(EnumType.STRING)
    private EnumSituacao situacao;

    @ManyToOne
    @JoinColumn(name = "id_curso")
    @JsonIgnore
    private Curso curso;

    public Aluno(AlunoDTO alunoDTO, CursoRepository cursoRepository) {
        this.id = alunoDTO.getId();
        this.nome = alunoDTO.getNome();
        this.dataNascimento = alunoDTO.getDataNascimento();
        this.cpf = alunoDTO.getCpf();
        this.situacao = alunoDTO.getSituacao();
        this.curso = cursoRepository.findById(alunoDTO.getCursoId())
                .orElseThrow(() -> new IllegalArgumentException("Curso não encontrado"));
    }

    public void updateFromDTO(AlunoDTO alunoDTO, CursoRepository cursoRepository) {
        this.nome = alunoDTO.getNome();
        this.dataNascimento = alunoDTO.getDataNascimento();
        this.cpf = alunoDTO.getCpf();
        this.situacao = alunoDTO.getSituacao();
        this.curso = cursoRepository.findById(alunoDTO.getCursoId())
                .orElseThrow(() -> new IllegalArgumentException("Curso não encontrado"));
    }
}
