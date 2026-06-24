package com.jar.SIGED.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jar.SIGED.Models.Entities.Alumno;
import com.jar.SIGED.Service.AlumnoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/alumnos")
public class AlumnoController {

    @Autowired
    private AlumnoService alumnoService;

    @GetMapping
    public ResponseEntity<List<Alumno>> obtenerAlumno(){
        return ResponseEntity.ok(alumnoService.getAllAlumnos());
    }

    @GetMapping("/id")
    public ResponseEntity<Alumno> obtenerAlumnoPorId(@PathVariable Integer id){
        Alumno alumno = alumnoService.getAlumnoById(id);
        if (alumno == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(alumno);
    }

    @PostMapping
    public ResponseEntity<Alumno> guardarAlumno(@Valid @RequestBody Alumno alumno){
        return ResponseEntity.status(201).body(alumnoService.saveAlumno(alumno));
    }

    @PutMapping("/id")
    public ResponseEntity<Alumno> actualizarAlumno(@PathVariable Integer id, @Valid @RequestBody Alumno alumno){
        alumno.setIdAlumno(id);
        Alumno actualizarAlumno = alumnoService.updateAlumno(alumno);
        if(actualizarAlumno == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(actualizarAlumno);
    }

    @DeleteMapping("/id")
    public ResponseEntity<Void> borrarAlumno(@PathVariable Integer id){
        alumnoService.deleteAlumno(id);
        return ResponseEntity.noContent().build();
    }
}
