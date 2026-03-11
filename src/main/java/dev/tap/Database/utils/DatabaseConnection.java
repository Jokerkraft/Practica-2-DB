package dev.tap.Database.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public final class DatabaseConnection {
    private static Connection connection;

    private DatabaseConnection() {
    }

    public static Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            String url = Env.obtenerRequerida("DB_URL");
            String user = Env.obtenerRequerida("DB_USER");
            String password = Env.obtenerRequerida("DB_PASSWORD");
            connection = DriverManager.getConnection(url, user, password);
        }
        return connection;
    }

    public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                System.err.println("Error al cerrar la conexion: " + e.getMessage());
            }
        }
    }

    public static void createUsuariosTable() throws SQLException {
        String sql = """
                CREATE TABLE IF NOT EXISTS usuarios (
                    id BIGINT AUTO_INCREMENT PRIMARY KEY,
                    nombre VARCHAR(120) NOT NULL,
                    email VARCHAR(120) NOT NULL UNIQUE,
                    password VARCHAR(120) NOT NULL,
                    fecha_registro DATE NOT NULL
                )
                """;

        try (Statement statement = getConnection().createStatement()) {
            statement.execute(sql);
        }
    }

    public static void createEstudiantesTable() throws SQLException {
        String sql = """
                CREATE TABLE IF NOT EXISTS estudiantes (
                    id INT AUTO_INCREMENT PRIMARY KEY,
                    nombre VARCHAR(100) NOT NULL,
                    correo VARCHAR(120) NOT NULL UNIQUE
                )
                """;

        try (Statement statement = getConnection().createStatement()) {
            statement.execute(sql);
        }
    }
}
