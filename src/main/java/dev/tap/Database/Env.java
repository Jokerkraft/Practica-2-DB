package dev.tap.Database;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class Env {
    private static final Path RUTA_ENV = Path.of(".env");
    private static final Map<String, String> VALORES_ENV = cargar();

    private Env() {
    }

    public static String obtenerRequerida(String nombre) {
        String valor = System.getenv(nombre);

        if (valor == null || valor.isBlank()) {
            valor = VALORES_ENV.get(nombre);
        }

        if (valor == null || valor.isBlank()) {
            throw new IllegalStateException("Falta la configuracion: " + nombre + " (variable del sistema o .env)");
        }

        return valor;
    }

    private static Map<String, String> cargar() {
        Map<String, String> valores = new HashMap<>();

        if (!Files.exists(RUTA_ENV)) {
            return valores;
        }

        try {
            List<String> lineas = Files.readAllLines(RUTA_ENV);
            for (String linea : lineas) {
                String limpia = linea.trim();
                if (limpia.isEmpty() || limpia.startsWith("#") || !limpia.contains("=")) {
                    continue;
                }

                String[] partes = limpia.split("=", 2);
                valores.put(partes[0].trim(), partes[1].trim());
            }
            return valores;
        } catch (IOException e) {
            throw new IllegalStateException("No se pudo leer el archivo .env en la raiz del proyecto", e);
        }
    }
}