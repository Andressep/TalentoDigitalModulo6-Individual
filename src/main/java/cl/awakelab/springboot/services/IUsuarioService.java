package cl.awakelab.springboot.services;

import cl.awakelab.springboot.models.entities.Alumno;
import cl.awakelab.springboot.models.entities.Usuario;

import java.util.List;

public interface IUsuarioService {
    public List<Usuario> listarUsuarios();
    public Usuario listarUsuarioPorId(Integer id);
    public Usuario crearUsuario(Usuario usuario);
    public void borrarUsuarioPorId(Integer id);
}
