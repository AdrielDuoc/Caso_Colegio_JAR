package com.jar.SIGED.Controller;

import com.jar.SIGED.Repository.CursoRepository;
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

import com.jar.SIGED.Models.Entities.Curso;
import com.jar.SIGED.Models.Entities.Docente;
import com.jar.SIGED.Service.CursoService;
import com.jar.SIGED.Service.DocenteService;

@RestController
@RequestMapping("/api/v1/cursos")
public class CursoController {

    @Autowired
    private CursoService cursoService;


    @GetMapping
    public ResponseEntity<List<Curso>> obtenerCurso(){
        return ResponseEntity.ok(cursoService.getAllCursos());
    }

    @GetMapping("/id")
    public ResponseEntity<Curso> obtenerCursoPorId(@PathVariable Integer id){
        Curso curso = cursoService.getCursoById(id);
        if (curso == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(curso);
    }

    @PostMapping
    public ResponseEntity<Curso> guardarCurso(@RequestBody Curso curso){
        return ResponseEntity.status(201).body(cursoService.saveCurso(curso));
    }

    @PutMapping("/id")
    public ResponseEntity<Curso> actualizarCurso(@PathVariable Integer id, @RequestBody Curso curso){
        curso.setIdCurso(id);;
        Curso actualizarCurso = cursoService.updateCurso(curso);
        if(actualizarCurso == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(actualizarCurso);
    }

    @DeleteMapping("/id")
    public ResponseEntity<Void> borrarCurso(@PathVariable Integer id){
        cursoService.deleteCurso(id);;
        return ResponseEntity.noContent().build();
    }
}