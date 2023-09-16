package cl.awakelab.springboot.models.entities;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@ToString
@Entity
@Table(name = "profesor_curso")
public class ProfesorCurso {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column(name = "profesor_curso_id")
    private Integer profesorCursoId;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "profesor_id")
    private Profesor profesor;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "curso_id")
    private Curso curso;

    public ProfesorCurso() {

    }
}
