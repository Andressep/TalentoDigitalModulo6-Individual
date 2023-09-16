package cl.awakelab.springboot.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@ToString
@Entity
@Table(name = "cursos")
public class Curso {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column(name = "curso_id")
    private Integer cursoId;
    @Column(name = "nombre_curso")
    private String nombreCurso;

    @JsonIgnore
    @OneToMany(mappedBy = "curso", cascade = CascadeType.ALL)
    private List<ProfesorCurso> profesores;

    @JsonIgnore
    @OneToMany(mappedBy = "cursoAlumno", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Alumno> listaAlumnos;

    public Curso() {
        profesores = new ArrayList<>();
        listaAlumnos = new ArrayList<>();
    }
}
