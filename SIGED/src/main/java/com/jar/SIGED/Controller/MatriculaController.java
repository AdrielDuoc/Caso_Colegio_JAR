package cl.duoc.siged.estudiantes.controller;

import cl.duoc.siged.estudiantes.model.Matricula;
import cl.duoc.siged.estudiantes.service.MatriculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/matriculas")
public class MatriculaController {

    @Autowired
    private MatriculaService service;

    @GetMapping
    public List<Matricula> listarTodas() {
        return service.obtenerTodas();
    }

    @GetMapping("/alumno/{alumnoId}")
    public List<Matricula> listarPorAlumno(@PathVariable Long alumnoId) {
        return service.obtenerPorAlumno(alumnoId);
    }

    @PostMapping
    public Matricula crearMatricula(@RequestBody Matricula matricula) {
        return service.registrarMatricula(matricula);
    }

    @PutMapping("/{id}/estado")
    public Matricula cambiarEstado(@PathVariable Long id, @RequestParam String estado) {
        return service.actualizarEstado(id, estado);
    }
}
