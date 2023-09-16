package cl.awakelab.springboot.models.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@ToString
@Entity
@Table(name = "profesores")
public class Profesor {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column(name = "profesor_id")
    private Integer profesorId;
    private String nombres;
    private String apellidoPaterno;
    private String apellidoMaterno;

    @OneToMany(mappedBy = "profesor", cascade = CascadeType.ALL)
    private List<ProfesorCurso> cursos;

    public Profesor() {
        cursos = new ArrayList<>();
    }
}
