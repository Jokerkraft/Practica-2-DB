package dev.tap.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestDb {
    public static void main(String[] args) {
        String url = Env.obtenerRequerida("DB_URL");
        String user = Env.obtenerRequerida("DB_USER");
        String password = Env.obtenerRequerida("DB_PASSWORD");

        try (
                Connection connection = DriverManager.getConnection(url, user, password);
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT NOW() AS db_time")) {

            System.out.println("Connected to MySQL successfully.");

            if (resultSet.next()) {
                System.out.println("Database time: " + resultSet.getString("db_time"));
            }
        } catch (SQLException exception) {
            System.err.println("MySQL connection failed: " + exception.getMessage());
        }
    }
}