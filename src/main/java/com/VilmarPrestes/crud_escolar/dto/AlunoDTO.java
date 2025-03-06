package com.VilmarPrestes.crud_escolar.dto;

import com.VilmarPrestes.crud_escolar.enums.EnumSituacao;
import com.VilmarPrestes.crud_escolar.model.Aluno;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AlunoDTO {

    private Long id;

    @NotBlank(message = "O nome é obrigatório")
    private String nome;

    @NotNull(message = "A data de nascimento é obrigatória")
    private LocalDate dataNascimento;

    @Pattern(regexp = "\\d{11}", message = "CPF deve conter 11 dígitos")
    private String cpf;

    @NotNull(message = "A situação é obrigatória")
    private EnumSituacao situacao;

    @NotNull(message = "O ID do curso é obrigatório")
    private Long cursoId;

    public AlunoDTO(Aluno aluno) {
        this.id = aluno.getId();
        this.nome = aluno.getNome();
        this.dataNascimento = aluno.getDataNascimento();
        this.cpf = aluno.getCpf();
        this.situacao = aluno.getSituacao();
        this.cursoId = aluno.getCurso().getId(); // Assumindo que Curso tem método getId()
    }
}
