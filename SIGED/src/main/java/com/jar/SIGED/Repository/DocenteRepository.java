package com.jar.SIGED.Repository;

import com.jar.SIGED.Models.Entities.Docente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocenteRepository extends JpaRepository<Docente, Integer> { }
