package cl.awakelab.springboot.services;

import cl.awakelab.springboot.models.entities.Curso;
import cl.awakelab.springboot.models.entities.Profesor;

import java.util.List;

public interface ICursoService {

    public List<Curso> listarCursos();
    public Curso listarCursoPorId(Integer id);
    public Curso crearCurso(Curso curso );
    public void borrarCursoPorId(Integer id);


}
