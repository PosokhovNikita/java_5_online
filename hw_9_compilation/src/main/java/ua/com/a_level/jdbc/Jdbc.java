package ua.com.a_level.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Jdbc {
    private static final Jdbc copy = new Jdbc();
    private Connection connection;
    private Statement statement;

    private final String driver = "com.mysql.cj.jdbc.Driver";
    private final String url = "jdbc:mysql://localhost:3306/new_schema";
    private final String userName = "root";
    private final String password = "Test123!";

    private Jdbc() {
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, userName, password);
            statement = connection.createStatement();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public static Jdbc getCopy() {
        return copy;
    }

    public Connection getConnection() {
        return connection;
    }

    public Statement getStatement() {
        return statement;
    }
}
