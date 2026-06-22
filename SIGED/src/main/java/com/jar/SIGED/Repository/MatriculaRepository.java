package cl.duoc.siged.estudiantes.repository;

import cl.duoc.siged.estudiantes.model.Matricula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MatriculaRepository extends JpaRepository<Matricula, Long> {

    List<Matricula> findByAlumnoId(Long alumnoId);

    List<Matricula> findByCursoId(Long cursoId);

    List<Matricula> findByAnioAcademico(Integer anioAcademico);

    Optional<Matricula> findByAlumnoIdAndAnioAcademico(Long alumnoId, Integer anioAcademico);

    List<Matricula> findByEstado(String estado);
}
