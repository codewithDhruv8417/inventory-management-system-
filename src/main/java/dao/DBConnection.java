package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.io.InputStream;
import java.util.Properties;

public class DBConnection {

    private static Connection connection = null;

    // Private constructor to prevent object creation
    private DBConnection() {}

    // Method to return the connection
    public static Connection getConnection() throws SQLException {

        if (connection == null || connection.isClosed()) {
            try {
                // Load properties file
                Properties props = new Properties();

                InputStream input = DBConnection.class
                        .getClassLoader()
                        .getResourceAsStream("config.properties");

                if (input == null) {
                    throw new RuntimeException("config.properties file is missing in src/main/resources/");
                }

                props.load(input);

                String url = props.getProperty("db.url");
                String username = props.getProperty("db.username");
                String password = props.getProperty("db.password");

                // Create connection
                connection = DriverManager.getConnection(url, username, password);

            } catch (Exception e) {
                throw new SQLException("Failed to connect to database", e);
            }
        }

        return connection;
    }
}
