package dev.tap.Database;

import dev.tap.Database.utils.DatabaseConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestDb {
    public static void main(String[] args) {
        try (
                Connection connection = DatabaseConnection.getConnection();
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT NOW() AS db_time")) {

            DatabaseConnection.createUsuariosTable();
            DatabaseConnection.createEstudiantesTable();

            System.out.println("Connected to MySQL successfully.");

            if (resultSet.next()) {
                System.out.println("Database time: " + resultSet.getString("db_time"));
            }
        } catch (SQLException exception) {
            System.err.println("MySQL connection failed: " + exception.getMessage());
        }
    }
}