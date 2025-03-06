package com.VilmarPrestes.crud_escolar.repository;

import com.VilmarPrestes.crud_escolar.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<Aluno, Long>  {

    boolean existsByCursoId(Long cursoId);
}
