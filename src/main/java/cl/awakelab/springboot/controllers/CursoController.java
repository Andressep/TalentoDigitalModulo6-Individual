package cl.awakelab.springboot.controllers;

import cl.awakelab.springboot.models.entities.Alumno;
import cl.awakelab.springboot.models.entities.Curso;
import cl.awakelab.springboot.models.entities.Profesor;
import cl.awakelab.springboot.services.impl.AlumnoServiceImpl;
import cl.awakelab.springboot.services.impl.CursoServiceImpl;
import cl.awakelab.springboot.services.impl.ProfesorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping(value = "api/v1")
public class CursoController {

    @Autowired
    private CursoServiceImpl cursoService;
    @Autowired
    private AlumnoServiceImpl alumnoService;
    @Autowired
    private ProfesorServiceImpl profesorService;

    @RequestMapping(value = "/cursos", method = RequestMethod.GET)
    public String listarCursos(Model model) {
        List<Curso> cursos = cursoService.listarCursos();
        model.addAttribute("titulo", "Cursos");
        model.addAttribute("cursos", cursos);
        return "templateListarCursos";
    }
    @RequestMapping(value = "/registrarCurso", method = RequestMethod.GET)
    public String formularioRegistrarCursos(Model model) {
        Curso curso = new Curso();
        List<Profesor> profesores = profesorService.listarProfesores();
        List<Alumno> alumnos = alumnoService.listarAlumnos();

        model.addAttribute("curso", curso);
        model.addAttribute("profesores", profesores);
        model.addAttribute("alumnos", alumnos);
        model.addAttribute("titulo", "Registrar Cursos");
        model.addAttribute("boton", "Crear");

        return "templateRegistrarCursos";
    }
    @RequestMapping(value = "/registrarCurso", method = RequestMethod.POST)
    public String registrarCurso(@ModelAttribute("curso") Curso curso) {
        cursoService.crearCurso(curso);

        return "redirect:/api/v1/cursos";
    }
    @RequestMapping(value = "/editarCurso/{id}", method = RequestMethod.GET)
    public String formularioEditarCurso(@PathVariable("id") int id, Model model) {
        Curso curso = cursoService.listarCursoPorId(id);

        if (curso == null) {
            // Manejo de error si el curso no existe
            return "redirect:/api/v1/cursos";
        }
        model.addAttribute("curso", curso);
        model.addAttribute("titulo", "Editar Curso");
        model.addAttribute("boton", "Editar");

        return "templateEditarCurso";
    }
    @RequestMapping(value = "/editarCurso/{id}", method = RequestMethod.POST)
    public String editarAlumno(@ModelAttribute("curso") Curso curso) {

        cursoService.crearCurso(curso);
        return "redirect:/api/v1/cursos";
    }
    @RequestMapping(value = "/eliminarCurso/{id}", method = RequestMethod.GET)
    public String eliminarAlumno(@PathVariable("id") int id) {
        cursoService.borrarCursoPorId(id);
        return "redirect:/api/v1/cursos";
    }
}
