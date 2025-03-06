package com.VilmarPrestes.crud_escolar.service;

import com.VilmarPrestes.crud_escolar.dto.CursoDTO;
import com.VilmarPrestes.crud_escolar.model.Curso;
import com.VilmarPrestes.crud_escolar.repository.AlunoRepository;
import com.VilmarPrestes.crud_escolar.repository.CursoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CursoService {
    private final CursoRepository cursoRepository;
    private final AlunoRepository alunoRepository;

    public CursoService(CursoRepository cursoRepository, AlunoRepository alunoRepository) {
        this.cursoRepository = cursoRepository;
        this.alunoRepository = alunoRepository;
    }

    public List<CursoDTO> getAll() {
        return cursoRepository.findAll().stream().map(CursoDTO::new).collect(Collectors.toList());
    }

    public CursoDTO save(CursoDTO cursoDTO) {
        Curso curso = new Curso(cursoDTO);
        curso = cursoRepository.save(curso);
        return new CursoDTO(curso);
    }

    public CursoDTO update(Long id, CursoDTO cursoDTO) {
        Optional<Curso> cursoExistente = cursoRepository.findById(id);
        if (cursoExistente.isEmpty()) {
            throw new IllegalArgumentException("Curso não encontrado");
        }
        Curso curso = cursoExistente.get();
        curso.updateFromDTO(cursoDTO);
        curso = cursoRepository.save(curso);
        return new CursoDTO(curso);
    }

    public void delete(Long id) {
        if (alunoRepository.existsByCursoId(id)) {
            throw new IllegalArgumentException("Não é possível deletar o curso enquanto houver alunos vinculados");
        }
        if (!cursoRepository.existsById(id)) {
            throw new IllegalArgumentException("Curso não encontrado");
        }
        cursoRepository.deleteById(id);
    }
}
