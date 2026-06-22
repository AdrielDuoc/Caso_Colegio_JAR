package com.jar.SIGED.Models.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Docentes")
public class Docente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDocente;

    @NotBlank
    private String nombreDocente;

    @NotBlank
    private String apellidoDocente;

    @NotBlank
    private String rutDocente;

    @NotBlank
    private String asignaturaDocente;
}
