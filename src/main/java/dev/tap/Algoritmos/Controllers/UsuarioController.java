package dev.tap.Algoritmos.Controllers;

import dev.tap.Algoritmos.Models.Usuario;
import dev.tap.Database.usuario.UsuarioDAO;

import java.util.List;

public class UsuarioController {
    private final UsuarioDAO usuarioDAO;

    public UsuarioController(UsuarioDAO usuarioDAO) {
        this.usuarioDAO = usuarioDAO;
    }

    public boolean crearUsuario(Usuario usuario) {
        return usuarioDAO.save(usuario);
    }

    public Usuario obtenerUsuarioPorId(Long id) {
        return usuarioDAO.findById(id);
    }

    public List<Usuario> listarUsuarios() {
        return usuarioDAO.findAll();
    }

    public List<Usuario> buscarPorNombre(String nombre) {
        return usuarioDAO.findByNombre(nombre);
    }

    public boolean actualizarUsuario(Usuario usuario) {
        return usuarioDAO.update(usuario);
    }

    public boolean eliminarUsuario(Long id) {
        return usuarioDAO.delete(id);
    }
}
