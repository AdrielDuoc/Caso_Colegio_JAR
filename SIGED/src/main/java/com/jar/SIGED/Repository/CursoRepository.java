package cl.duoc.siged.cursos.repository;

import cl.duoc.siged.cursos.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Long> {

    List<Curso> findByDocenteId(Long docenteId);

    List<Curso> findByNivelAndAnioAcademico(String nivel, Integer anioAcademico);

    Optional<Curso> findByNivelAndSeccionAndAnioAcademico(String nivel, String seccion, Integer anioAcademico);
}
