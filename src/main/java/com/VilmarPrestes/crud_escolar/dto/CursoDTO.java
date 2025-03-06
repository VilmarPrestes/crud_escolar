package com.VilmarPrestes.crud_escolar.dto;

import com.VilmarPrestes.crud_escolar.model.Curso;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Future;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CursoDTO {

    private Long id;

    @NotBlank(message = "O nome é obrigatório")
    private String nome;

    @NotNull(message = "A data de início das aulas é obrigatória")
    @Future(message = "A data de início deve ser no futuro")
    private LocalDateTime inicioAulas;

    @NotNull(message = "A data de fim das aulas é obrigatória")
    @Future(message = "A data de fim deve ser no futuro")
    private LocalDateTime fimAulas;

    @NotNull(message = "O status do curso é obrigatório")
    private Boolean ativo;

    public CursoDTO(Curso curso) {
        this.id = curso.getId();
        this.nome = curso.getNome();
        this.inicioAulas = curso.getInicioAulas();
        this.fimAulas = curso.getFimAulas();
        this.ativo = curso.getAtivo();
    }
}
