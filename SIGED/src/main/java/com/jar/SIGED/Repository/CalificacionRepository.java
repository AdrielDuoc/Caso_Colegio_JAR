package com.jar.SIGED.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.jar.SIGED.Models.Entities.Calificacion;

@Repository
public interface CalificacionRepository extends JpaRepository<Calificacion, Integer>{ }
