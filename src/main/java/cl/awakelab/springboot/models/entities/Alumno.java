package cl.awakelab.springboot.models.entities;

import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@ToString
@Entity
@Table(name = "alumnos")
public class Alumno {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Integer AlumnoId;
    private String nombres;
    private String apellidoPaterno;
    private String apellidoMaterno;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "curso_id")
    private Curso cursoAlumno;

    public Alumno() {}
}
