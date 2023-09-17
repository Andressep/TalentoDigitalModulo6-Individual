package cl.awakelab.springboot.controllers;

import cl.awakelab.springboot.models.entities.Alumno;
import cl.awakelab.springboot.models.entities.Curso;
import cl.awakelab.springboot.services.impl.AlumnoServiceImpl;
import cl.awakelab.springboot.services.impl.CursoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "api/v1")
public class AlumnoController {

    @Autowired
    private AlumnoServiceImpl alumnoService;
    @Autowired
    private CursoServiceImpl cursoService;

    @RequestMapping(value = "/alumnos", method = RequestMethod.GET)
    public String listarAlumnos(Model model) {
        List<Alumno> alumnos = alumnoService.listarAlumnos();
        model.addAttribute("titulo", "Alumnos");
        model.addAttribute("alumnos", alumnos);
        return "templateListarAlumnos";
    }

    @RequestMapping(value = "/registrarAlumno", method = RequestMethod.GET)
    public String formularioRegistrarAlumno(Model model) {
        Alumno alumno = new Alumno();
        List<Curso> cursos = cursoService.listarCursos();
        model.addAttribute("alumno", alumno);
        model.addAttribute("cursos", cursos);
        model.addAttribute("titulo", "Registrar Alumno");
        model.addAttribute("boton", "Crear");

        return "templateRegistrarAlumnos";
    }
    @RequestMapping(value = "/registrarAlumno", method = RequestMethod.POST)
    public String registrarAlumno(@ModelAttribute("alumno") Alumno alumno) {
        alumnoService.crearAlumno(alumno);

        return "redirect:/api/v1/alumnos";
    }
    @RequestMapping(value = "/editarAlumno/{id}", method = RequestMethod.GET)
    public String formularioEditarAlumno(@PathVariable("id") int id, Model model) {
        Alumno alumno = alumnoService.listarAlumnoPorId(id);
        List<Curso> listaCursos = cursoService.listarCursos();

        if (alumno == null) {
            // Manejo de error si el alumno no existe
            return "redirect:/api/v1/alumnos";
        }

        model.addAttribute("titulo", "Editar Alumno");
        model.addAttribute("alumno", alumno);
        model.addAttribute("cursos", listaCursos);
        model.addAttribute("boton", "Editar");


        return "templateEditarAlumnos";
    }
    @RequestMapping(value = "/editarAlumno/{id}", method = RequestMethod.POST)
    public String editarAlumno(@ModelAttribute("alumno") Alumno alumno) {

        alumnoService.crearAlumno(alumno);
        return "redirect:/api/v1/alumnos";
    }
    @RequestMapping(value = "/eliminarAlumno/{id}", method = RequestMethod.GET)
    public String eliminarAlumno(@PathVariable("id") int id) {
        alumnoService.borrarAlumnoPorId(id);
        return "redirect:/api/v1/alumnos";
    }
}
