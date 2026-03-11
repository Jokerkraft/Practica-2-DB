package dev.tap;

import dev.tap.Algoritmos.Controllers.EstudianteController;
import dev.tap.Algoritmos.Controllers.UsuarioController;
import dev.tap.Algoritmos.Views.EstudianteView;
import dev.tap.Algoritmos.Views.UsuarioView;
import dev.tap.Database.estudiante.EstudianteDAOImpl;
import dev.tap.Database.usuario.UsuarioDAO;
import dev.tap.Database.utils.DatabaseConnection;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        try {
            Connection connection = DatabaseConnection.getConnection();
            DatabaseConnection.createUsuariosTable();
            DatabaseConnection.createEstudiantesTable();

            UsuarioDAO usuarioDAO = new UsuarioDAO(connection);
            EstudianteDAOImpl estudianteDAO = new EstudianteDAOImpl(connection);

            UsuarioController usuarioController = new UsuarioController(usuarioDAO);
            EstudianteController estudianteController = new EstudianteController(estudianteDAO);

            UsuarioView usuarioView = new UsuarioView(usuarioController);
            EstudianteView estudianteView = new EstudianteView(estudianteController);

            usuarioView.mostrarDemoCrud();
            estudianteView.mostrarDemoCrud();

            DatabaseConnection.closeConnection();
        } catch (SQLException e) {
            System.err.println("Error de base de datos: " + e.getMessage());
        }
    }
}