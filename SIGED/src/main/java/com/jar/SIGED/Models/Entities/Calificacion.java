package com.jar.SIGED.Models.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "calificaciones")
public class Calificacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCalificacion;

    @NotNull
    private double notaCalificacion;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "idAsignatura")
    private Asignatura asignatura;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "idAlumno")
    private Alumno alumno;
}
