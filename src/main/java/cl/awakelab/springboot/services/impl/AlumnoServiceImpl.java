package cl.awakelab.springboot.services.impl;

import cl.awakelab.springboot.models.entities.Alumno;
import cl.awakelab.springboot.repositories.IAlumnoRepository;
import cl.awakelab.springboot.services.IAlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("AlumnoServiceImpl")
public class AlumnoServiceImpl implements IAlumnoService {

    @Autowired
    private IAlumnoRepository alumnoRepository;
    @Override
    public List<Alumno> listarAlumnos() {
        return alumnoRepository.findAll();
    }

    @Override
    public Alumno listarAlumnoPorId(Integer id) {
        return alumnoRepository.findById(id).orElse(null);
    }

    @Override
    public Alumno crearAlumno(Alumno alumno) {
        return alumnoRepository.save(alumno);
    }

    @Override
    public void borrarAlumnoPorId(Integer id) {
        alumnoRepository.deleteById(id);
    }
}
