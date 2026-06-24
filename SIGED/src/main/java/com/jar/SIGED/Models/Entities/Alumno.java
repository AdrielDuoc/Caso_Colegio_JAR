package com.jar.SIGED.Models.Entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Alumnos")
public class Alumno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idAlumno;

    @NotBlank
    private String nombreAlumno;

    @NotBlank
    private String apellidoAlumno;

    @NotNull
    private Integer edadAlumno;

    @NotBlank
    private String rutAlumno;

    @NotNull
    @OneToMany
    @JoinColumn(name = "idAsignatura")
    private List<Asignatura> asignatura;
}
