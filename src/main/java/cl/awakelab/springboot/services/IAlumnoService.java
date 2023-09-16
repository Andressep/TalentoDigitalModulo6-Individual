package cl.awakelab.springboot.services;

import cl.awakelab.springboot.models.entities.Alumno;

import java.util.List;

public interface IAlumnoService {
    public List<Alumno> listarAlumnos();
    public Alumno listarAlumnoPorId(Integer id);
    public Alumno crearAlumno(Alumno alumno);
    public void borrarAlumnoPorId(Integer id);
}
