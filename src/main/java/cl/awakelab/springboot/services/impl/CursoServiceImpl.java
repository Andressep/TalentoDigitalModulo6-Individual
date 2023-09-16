package cl.awakelab.springboot.services.impl;

import cl.awakelab.springboot.models.entities.Curso;
import cl.awakelab.springboot.repositories.ICursoRepository;
import cl.awakelab.springboot.services.ICursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("CursoServiceImpl")
public class CursoServiceImpl implements ICursoService {

    @Autowired
    private ICursoRepository cursoRepository;
    @Override
    public List<Curso> listarCursos() {
        return cursoRepository.findAll();
    }

    @Override
    public Curso listarCursoPorId(Integer id) {
        return cursoRepository.findById(id).orElse(null);
    }

    @Override
    public Curso crearCurso(Curso curso) {
        return cursoRepository.save(curso);
    }

    @Override
    public void borrarCursoPorId(Integer id) {
        cursoRepository.deleteById(id);
    }
}
