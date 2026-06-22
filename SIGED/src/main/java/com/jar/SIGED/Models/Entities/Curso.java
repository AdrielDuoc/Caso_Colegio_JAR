package cl.duoc.siged.model;

import jakarta.persistence.*;

@Entity
@Table(name = "cursos")
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String nivel;

    @Column(nullable = false, length = 1)
    private String seccion;

    @Column(nullable = false)
    private Integer anio;

    @Column(nullable = false)
    private Long docenteJefeId;

    public Curso() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNivel() { return nivel; }
    public void setNivel(String nivel) { this.nivel = nivel; }

    public String getSeccion() { return seccion; }
    public void setSeccion(String seccion) { this.seccion = seccion; }

    public Integer getAnio() { return anio; }
    public void setAnio(Integer anio) { this.anio = anio; }

    public Long getDocenteJefeId() { return docenteJefeId; }
    public void setDocenteJefeId(Long docenteJefeId) { this.docenteJefeId = docenteJefeId; }
}
