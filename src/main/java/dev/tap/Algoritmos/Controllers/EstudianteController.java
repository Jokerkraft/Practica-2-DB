package dev.tap.Algoritmos.Controllers;

import dev.tap.Algoritmos.Models.Estudiante;
import dev.tap.Database.estudiante.EstudianteDAO;

import java.util.List;

public class EstudianteController {
    private final EstudianteDAO estudianteDAO;

    public EstudianteController(EstudianteDAO estudianteDAO) {
        this.estudianteDAO = estudianteDAO;
    }

    public boolean crearEstudiante(Estudiante estudiante) {
        return estudianteDAO.insertar(estudiante);
    }

    public Estudiante obtenerEstudiantePorId(int id) {
        return estudianteDAO.obtenerPorId(id);
    }

    public List<Estudiante> listarEstudiantes() {
        return estudianteDAO.listar();
    }

    public boolean actualizarEstudiante(Estudiante estudiante) {
        return estudianteDAO.actualizar(estudiante);
    }

    public boolean eliminarEstudiante(int id) {
        return estudianteDAO.eliminar(id);
    }
}
