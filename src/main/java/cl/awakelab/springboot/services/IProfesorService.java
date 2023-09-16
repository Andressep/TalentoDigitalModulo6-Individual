package cl.awakelab.springboot.services;

import cl.awakelab.springboot.models.entities.Profesor;

import java.util.List;

public interface IProfesorService {

    public List<Profesor> listarProfesores();
    public Profesor listarProfesorPorId(Integer id);
    public Profesor crearProfesor(Profesor profesor);
    public void borrarProfesorPorId(Integer id);

}
