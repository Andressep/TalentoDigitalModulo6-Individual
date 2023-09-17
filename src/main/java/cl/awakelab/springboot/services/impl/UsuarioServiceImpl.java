package cl.awakelab.springboot.services.impl;

import cl.awakelab.springboot.models.entities.Alumno;
import cl.awakelab.springboot.models.entities.Usuario;
import cl.awakelab.springboot.repositories.IUsuarioRepository;
import cl.awakelab.springboot.services.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("UsuarioServiceImpl")
public class UsuarioServiceImpl implements IUsuarioService {

    @Autowired
    private IUsuarioRepository usuarioRepository;

    @Override
    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario listarUsuarioPorId(Integer id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    @Override
    public Usuario crearUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public void borrarUsuarioPorId(Integer id) {
        usuarioRepository.deleteById(id);
    }
}
