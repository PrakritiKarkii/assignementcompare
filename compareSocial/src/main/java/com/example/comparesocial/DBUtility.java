package com.example.comparesocial;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Utility class for managing database connections and resources.
 */
public class DBUtility {

    // JDBC connection parameters
    private static final String URL = "jdbc:mysql://localhost:3306/social_media_engagement"; // Database URL
    private static final String USERNAME = "root"; // Database username
    private static final String PASSWORD = "12345"; // Database password

    /**
     * Establishes a connection to the database.
     *
     * @return Connection object to the database
     * @throws SQLException if a database access error occurs
     */
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }

    /**
     * Closes an AutoCloseable resource (e.g., ResultSet, Statement, Connection).
     *
     * @param resource the AutoCloseable resource to close
     */
    public static void close(AutoCloseable resource) {
        if (resource != null) {
            try {
                resource.close();
            } catch (Exception e) {
                e.printStackTrace(); // Print stack trace for any closing errors
            }
        }
    }
}
