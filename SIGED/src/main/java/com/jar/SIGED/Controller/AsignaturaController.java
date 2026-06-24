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

import com.jar.SIGED.Models.Entities.Asignatura;
import com.jar.SIGED.Service.AsignaturaService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/asignaturas")
public class AsignaturaController {

    @Autowired
    private AsignaturaService asignaturaService;

    @GetMapping
    public ResponseEntity<List<Asignatura>> obtenerAsignaturas(){
        return ResponseEntity.ok(asignaturaService.getAllAsignaturas());
    }

    @GetMapping("/id")
    public ResponseEntity<Asignatura> obtenerAsignaturaPorId(@PathVariable Integer id){
        Asignatura asignatura = asignaturaService.getAsignaturaById(id);
        if (asignatura == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(asignatura);
    }

    @PostMapping
    public ResponseEntity<Asignatura> guardarAsignatura(@Valid @RequestBody Asignatura asignatura){
        return ResponseEntity.status(201).body(asignaturaService.saveAsignatura(asignatura));
    }

    @PutMapping("/id")
    public ResponseEntity<Asignatura> actualizarAsignatura(@PathVariable Integer id, @Valid @RequestBody Asignatura asignatura){
        asignatura.setIdAsignatura(id);
        Asignatura actualizarAsignatura = asignaturaService.updateAsignatura(asignatura);
        if(actualizarAsignatura == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(actualizarAsignatura);
    }

    @DeleteMapping("/id")
    public ResponseEntity<Void> borrarAsignatura(@PathVariable Integer id){
        asignaturaService.deleteAsignatura(id);
        return ResponseEntity.noContent().build();
    }
}
