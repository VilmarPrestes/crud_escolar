package com.VilmarPrestes.crud_escolar.repository;

import com.VilmarPrestes.crud_escolar.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Curso, Long> {
}
