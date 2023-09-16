package cl.awakelab.springboot.controllers;

import cl.awakelab.springboot.models.entities.Profesor;
import cl.awakelab.springboot.services.impl.ProfesorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping(value = "api/v1")
public class ProfesorController {

    @Autowired
    private ProfesorServiceImpl profesorService;

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
        model.addAttribute("profesor", profesor);
        model.addAttribute("titulo", "Registrar Profesor");
        return "templateRegistrarProfesores";
    }

    @RequestMapping(value = "/registrarProfesor", method = RequestMethod.POST)
    public String registrarProfesor(Profesor profesor) {
        profesorService.crearProfesor(profesor);
        return "redirect:/api/v1/profesores";
    }
}
