package com.jar.SIGED.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.jar.SIGED.Models.Entities.Asignatura;

@Repository
public interface AsignaturaRepository extends JpaRepository<Asignatura, Integer> { } 


