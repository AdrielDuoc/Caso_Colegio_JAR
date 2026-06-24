package com.jar.SIGED.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.jar.SIGED.Models.Entities.Curso;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Integer> { }