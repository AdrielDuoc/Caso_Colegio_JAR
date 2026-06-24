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

import com.jar.SIGED.Models.Entities.Calificacion;
import com.jar.SIGED.Service.CalificacionService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/Calificaciones")
public class CalificacionController {

    @Autowired
    private CalificacionService calificacionService;

    @GetMapping
    public ResponseEntity<List<Calificacion>> obtnerCalificaciones(){
        return ResponseEntity.ok(calificacionService.getAllCalificacion());
    }

    @GetMapping("/id")
    public ResponseEntity<Calificacion> obtenerCalificacionPorId(@PathVariable Integer id){
        Calificacion calificacion = calificacionService.getCalificacionById(id);
        if(calificacion == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(calificacion);
    }

    @PostMapping
    public ResponseEntity<Calificacion> guardarCalificacion(@Valid @RequestBody Calificacion calificacion){
        return ResponseEntity.status(201).body(calificacionService.saveCalificacion(calificacion));
    }

    @PutMapping("/id")
    public ResponseEntity<Calificacion> actualizarCalificacion(@PathVariable Integer id, @Valid @RequestBody Calificacion calificacion){
        calificacion.setIdCalificacion(id);
        Calificacion actualizarCalificacion = calificacionService.updateCalificacion(calificacion);
        if(actualizarCalificacion == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(actualizarCalificacion);
    }

    @DeleteMapping("/id")
    public ResponseEntity<Void> borrarCalificacion(@PathVariable Integer id){
        calificacionService.deleteCalificacion(id);
        return ResponseEntity.noContent().build();
    }
}
