package dev.tap.Algoritmos.Views;

import dev.tap.Algoritmos.Controllers.UsuarioController;
import dev.tap.Algoritmos.Models.Usuario;

import java.time.LocalDate;
import java.util.List;

public class UsuarioView {

    private final UsuarioController usuarioController;

    public UsuarioView(UsuarioController usuarioController) {
        this.usuarioController = usuarioController;
    }

    public void mostrarDemoCrud() {
        Usuario usuario = new Usuario();
        usuario.setNombre("Juan Perez");
        usuario.setEmail("juan@example.com");
        usuario.setPassword("123456");
        usuario.setFechaRegistro(LocalDate.now());

        if (usuarioController.crearUsuario(usuario)) {
            System.out.println("[UsuarioView] Usuario creado con ID: " + usuario.getId());
        }

        Usuario encontrado = usuarioController.obtenerUsuarioPorId(usuario.getId());
        if (encontrado != null) {
            encontrado.setNombre("Juan P. Actualizado");
            usuarioController.actualizarUsuario(encontrado);
        }

        List<Usuario> usuarios = usuarioController.listarUsuarios();
        System.out.println("[UsuarioView] Total usuarios: " + usuarios.size());

        List<Usuario> porNombre = usuarioController.buscarPorNombre("Juan");
        System.out.println("[UsuarioView] Coincidencias por nombre 'Juan': " + porNombre.size());
    }
}
