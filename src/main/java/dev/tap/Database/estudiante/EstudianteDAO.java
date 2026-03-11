package dev.tap.Database.estudiante;

import dev.tap.Algoritmos.Models.Estudiante;

import java.util.List;

public interface EstudianteDAO {
    boolean insertar(Estudiante estudiante);

    Estudiante obtenerPorId(int id);

    List<Estudiante> listar();

    boolean actualizar(Estudiante estudiante);

    boolean eliminar(int id);
}
