package cl.awakelab.springboot.services.impl;

import cl.awakelab.springboot.models.entities.Profesor;
import cl.awakelab.springboot.repositories.IProfesorRepository;
import cl.awakelab.springboot.services.IProfesorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("ProfesorServiceImpl")
public class ProfesorServiceImpl implements IProfesorService {

    @Autowired
    private IProfesorRepository profesorRepository;
    @Override
    public List<Profesor> listarProfesores() {
        return profesorRepository.findAll();
    }

    @Override
    public Profesor listarProfesorPorId(Integer id) {
        return profesorRepository.findById(id).orElse(null);
    }

    @Override
    public Profesor crearProfesor(Profesor profesor) {
        return profesorRepository.save(profesor);
    }

    @Override
    public void borrarProfesorPorId(Integer id) {
    profesorRepository.deleteById(id);
    }
}
