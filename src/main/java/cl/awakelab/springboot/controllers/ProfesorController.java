package cl.awakelab.springboot.controllers;

import cl.awakelab.springboot.models.entities.Curso;
import cl.awakelab.springboot.models.entities.Profesor;
import cl.awakelab.springboot.models.entities.ProfesorCurso;
import cl.awakelab.springboot.services.impl.CursoServiceImpl;
import cl.awakelab.springboot.services.impl.ProfesorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "api/v1")
public class ProfesorController {

    @Autowired
    private ProfesorServiceImpl profesorService;
    @Autowired
    private CursoServiceImpl cursoService;

    @RequestMapping(value = "/profesores", method = RequestMethod.GET)
    public String listarProfesores(Model model) {
        List<Profesor> profesores = profesorService.listarProfesores();
        model.addAttribute("titulo", "Profesores");
        model.addAttribute("profesores", profesores);
        return "templateListarProfesores";
    }

    @RequestMapping(value = "/registrarProfesor", method = RequestMethod.GET)
    public String formularioRegistrarProfesor(Model model) {
        Profesor profesor = new Profesor();
        List<Curso> cursos = cursoService.listarCursos();

        model.addAttribute("profesor", profesor);
        model.addAttribute("cursos", cursos);
        model.addAttribute("titulo", "Registrar Profesor");
        return "templateRegistrarProfesores";
    }
    @RequestMapping(value = "/registrarProfesor", method = RequestMethod.POST)
    public String registrarProfesor(@ModelAttribute("profesor") Profesor profesor, @RequestParam("cursosSeleccionados") List<Integer> cursosSeleccionados) {

        // Crea una lista para almacenar los objetos ProfesorCurso
        List<ProfesorCurso> profesorCursos = new ArrayList<>();

        // Itera sobre los cursos seleccionados y crea ProfesorCurso para cada uno
        for (Integer cursoId : cursosSeleccionados) {
            Curso curso = cursoService.listarCursoPorId(cursoId); // Reemplaza esto con tu método para obtener cursos por ID
            ProfesorCurso profesorCurso = new ProfesorCurso();
            profesorCurso.setCurso(curso);
            profesorCurso.setProfesor(profesor);
            profesorCursos.add(profesorCurso);
        }
        // Asigna la lista de ProfesorCurso al profesor
        profesor.setCursos(profesorCursos);

        profesorService.crearProfesor(profesor);

        return "redirect:/api/v1/profesores";
    }
    @RequestMapping(value = "/editarProfesor/{id}", method = RequestMethod.GET)
    public String formularioEditarProfesor(@PathVariable("id") int id, Model model) {
        Profesor profesor = profesorService.listarProfesorPorId(id); // Reemplaza con tu lógica para obtener el profesor por su ID
        List<Curso> cursos = cursoService.listarCursos();

        // Verifica si el profesor existe
        if (profesor == null) {
            // Manejo de error si el profesor no existe
            return "redirect:/api/v1/profesores";
        }
        // Asigna los cursos seleccionados al profesor
        List<Integer> cursosSeleccionados = new ArrayList<>();
        for (ProfesorCurso profesorCurso : profesor.getCursos()) {
            cursosSeleccionados.add(profesorCurso.getCurso().getCursoId());
        }
        // Agrega profesor y cursos al modelo
        model.addAttribute("profesor", profesor);
        model.addAttribute("cursos", cursos);
        model.addAttribute("cursosSeleccionados", cursosSeleccionados);
        model.addAttribute("titulo", "Editar Profesor");

        return "templateEditarProfesores";
    }
    @RequestMapping(value = "/editarProfesor/{id}", method = RequestMethod.POST)
    public String editarProfesor(@ModelAttribute("profesor") Profesor profesor, @RequestParam("cursosSeleccionados") List<Integer> cursosSeleccionados) {
        // Resto del código...

        // Actualiza los cursos del profesor
        List<ProfesorCurso> profesorCursos = new ArrayList<>();
        for (Integer cursoId : cursosSeleccionados) {
            Curso curso = cursoService.listarCursoPorId(cursoId); // Reemplaza con tu lógica para obtener cursos por ID
            ProfesorCurso profesorCurso = new ProfesorCurso();
            profesorCurso.setCurso(curso);
            profesorCurso.setProfesor(profesor);
            profesorCursos.add(profesorCurso);
        }
        profesor.setCursos(profesorCursos);

        profesorService.crearProfesor(profesor);
        return "redirect:/api/v1/profesores";
    }
    @RequestMapping(value = "/eliminarProfesor/{id}", method = RequestMethod.GET)
    public String eliminarProfesor(@PathVariable("id") int id) {
        profesorService.borrarProfesorPorId(id);
        return "redirect:/api/v1/profesores";
    }
}
