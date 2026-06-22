package com.jar.SIGED.Models.Repository;

import com.jar.SIGED.Models.Entities.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlumnoRepository extends JpaRepository<Alumno, Integer> { }