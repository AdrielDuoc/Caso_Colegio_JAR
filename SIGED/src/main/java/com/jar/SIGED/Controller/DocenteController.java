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

import com.jar.SIGED.Models.Entities.Docente;
import com.jar.SIGED.Service.DocenteService;

@RestController
@RequestMapping("/api/v1/docentes")
public class DocenteController {

    @Autowired
    private DocenteService docenteService;

    @GetMapping
    public ResponseEntity<List<Docente>> obtenerDocentes(){
        return ResponseEntity.ok(docenteService.getAllDocentes());
    }

    @GetMapping("/id")
    public ResponseEntity<Docente> obtenerDocentePorId(@PathVariable Integer id){
        Docente docente = docenteService.getDocenteById(id);
        if (docente == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(docente);
    }

    @PostMapping
    public ResponseEntity<Docente> guardarDocente(@RequestBody Docente docente){
        return ResponseEntity.status(201).body(docenteService.saveDocente(docente));
    }

    @PutMapping("/id")
    public ResponseEntity<Docente> actualizarDocente(@PathVariable Integer id, @RequestBody Docente docente){
        docente.setIdDocente(id);
        Docente actualizarDocente = docenteService.updateDocente(docente);
        if(actualizarDocente == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(actualizarDocente);
    }

    @DeleteMapping("/id")
    public ResponseEntity<Void> borrarDocente(@PathVariable Integer id){
        docenteService.deleteDocente(id);
        return ResponseEntity.noContent().build();
    }
}