package com.VilmarPrestes.crud_escolar.service;

import com.VilmarPrestes.crud_escolar.dto.AlunoDTO;
import com.VilmarPrestes.crud_escolar.model.Aluno;
import com.VilmarPrestes.crud_escolar.repository.AlunoRepository;
import com.VilmarPrestes.crud_escolar.repository.CursoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AlunoService {
    private final AlunoRepository alunoRepository;
    private final CursoRepository cursoRepository;

    public AlunoService(AlunoRepository alunoRepository, CursoRepository cursoRepository) {
        this.alunoRepository = alunoRepository;
        this.cursoRepository = cursoRepository;
    }

    public List<AlunoDTO> getAll() {
        return alunoRepository.findAll().stream().map(AlunoDTO::new).collect(Collectors.toList());
    }

    public AlunoDTO save(AlunoDTO alunoDTO) {
        validarCurso(alunoDTO.getCursoId());
        Aluno aluno = new Aluno(alunoDTO, cursoRepository);
        aluno = alunoRepository.save(aluno);
        return new AlunoDTO(aluno);
    }

    public AlunoDTO update(Long id, AlunoDTO alunoDTO) {
        Optional<Aluno> alunoExistente = alunoRepository.findById(id);
        if (alunoExistente.isEmpty()) {
            throw new IllegalArgumentException("Aluno não encontrado no banco de dados");
        }
        validarCurso(alunoDTO.getCursoId());
        Aluno aluno = alunoExistente.get();
        aluno.updateFromDTO(alunoDTO, cursoRepository);
        aluno = alunoRepository.save(aluno);
        return new AlunoDTO(aluno);
    }

    public void delete(Long id) {
        if (!alunoRepository.existsById(id)) {
            throw new IllegalArgumentException("Impossível deletar um aluno não cadastrado");
        }
        alunoRepository.deleteById(id);
    }

    private void validarCurso(Long cursoId) {
        if (!cursoRepository.existsById(cursoId)) {
            throw new IllegalArgumentException("Curso id inválido");
        }
    }
}
