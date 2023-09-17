package cl.awakelab.springboot.controllers;

import cl.awakelab.springboot.models.entities.Alumno;
import cl.awakelab.springboot.models.entities.Curso;
import cl.awakelab.springboot.models.entities.Usuario;
import cl.awakelab.springboot.services.impl.UsuarioServiceImpl;
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
public class UsuarioController {

    @Autowired
    private UsuarioServiceImpl usuarioService;

    @RequestMapping(value = "/usuarios", method = RequestMethod.GET)
    public String listarUsuarios(Model model) {
        List<Usuario> usuarios = usuarioService.listarUsuarios();
        model.addAttribute("titulo", "Usuarios");
        model.addAttribute("usuarios", usuarios);
        return "templateListarUsuarios";
    }
    @RequestMapping(value = "/registrarUsuario", method = RequestMethod.GET)
    public String formularioRegistrarUsuario(Model model) {
        Usuario usuario = new Usuario();
        model.addAttribute("usuario", usuario);
        model.addAttribute("titulo", "Registrar Usuario");
        model.addAttribute("boton", "Crear");

        return "templateRegistrarUsuarios";
    }
    @RequestMapping(value = "/registrarUsuario", method = RequestMethod.POST)
    public String registrarAlumno(@ModelAttribute("usuario") Usuario usuario) {
        usuarioService.crearUsuario(usuario);

        return "redirect:/api/v1/usuarios";
    }
    @RequestMapping(value = "/editarUsuario/{id}", method = RequestMethod.GET)
    public String formularioEditarUsuario(@PathVariable("id") int id, Model model) {
        Usuario usuario = usuarioService.listarUsuarioPorId(id);

        if (usuario == null) {
            // Manejo de error si el usuario no existe
            return "redirect:/api/v1/usuarios";
        }

        model.addAttribute("titulo", "Editar Usuario");
        model.addAttribute("usuario", usuario);
        model.addAttribute("boton", "Editar");

        return "templateEditarUsuarios";
    }
    @RequestMapping(value = "/editarUsuario/{id}", method = RequestMethod.POST)
    public String editarUsuario(@ModelAttribute("usuario") Usuario usuario) {

        usuarioService.crearUsuario(usuario);
        return "redirect:/api/v1/usuarios";
    }
    @RequestMapping(value = "/eliminarUsuario/{id}", method = RequestMethod.GET)
    public String eliminarUsuario(@PathVariable("id") int id) {
        usuarioService.borrarUsuarioPorId(id);
        return "redirect:/api/v1/usuarios";
    }
}
