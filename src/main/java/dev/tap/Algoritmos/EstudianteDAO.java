package dev.tap.Algoritmos;

import java.util.List;

public interface EstudianteDAO {
    void Insertar(Estudiante e);

    Estudiante obtenerPorId(int id);

    List<Estudiante> listar();

    void eliminar(int id);

    void insertar(Estudiante e);

    void actualizar(Estudiante e);
}
