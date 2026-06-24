
package com.jar.SIGED.Models.Entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "asignaturas")
public class Asignatura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idAsignatura;

    @NotBlank
    private String nombre;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "idCurso")
    private Curso curso;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "idDocente")
    private Docente docente;
}
