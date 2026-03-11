package dev.tap.Algoritmos.Views;

import dev.tap.Algoritmos.Controllers.EstudianteController;
import dev.tap.Algoritmos.Models.Estudiante;

import java.util.List;

public class EstudianteView {

    private final EstudianteController estudianteController;

    public EstudianteView(EstudianteController estudianteController) {
        this.estudianteController = estudianteController;
    }

    public void mostrarDemoCrud() {
        Estudiante estudiante = new Estudiante(0, "Ana Torres", "ana@example.com");

        if (estudianteController.crearEstudiante(estudiante)) {
            System.out.println("[EstudianteView] Estudiante creado con ID: " + estudiante.getId());
        }

        Estudiante encontrado = estudianteController.obtenerEstudiantePorId(estudiante.getId());
        if (encontrado != null) {
            encontrado.setNombre("Ana T. Actualizada");
            estudianteController.actualizarEstudiante(encontrado);
        }

        List<Estudiante> estudiantes = estudianteController.listarEstudiantes();
        System.out.println("[EstudianteView] Total estudiantes: " + estudiantes.size());
    }
}
