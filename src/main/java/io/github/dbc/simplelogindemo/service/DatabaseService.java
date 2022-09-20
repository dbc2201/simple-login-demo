package io.github.dbc.simplelogindemo.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseService {
    private static final String USERNAME = "root";
    private static final String PASSWORD = "admin";
    private static final String URL = "jdbc:mysql://localhost:3306/users";

    private Connection connection;

    public DatabaseService() {
        this.connection = null;
    }

    public Connection getConnection() {
        return connection;
    }

    public boolean connect() {
        try {
            this.connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            printConnectionStatus();
            return true;
        } catch (SQLException exception) {
            System.err.println("Could not connect to the database!!");
            exception.printStackTrace();
            printConnectionStatus();
            return false;
        }
    }

    public void printConnectionStatus() {
        if (connection != null) {
            System.out.println(" \u001B[32m CONNECTION : ACTIVE \u001B[32m");
        } else {
            System.err.println("CONNECTION : INACTIVE");
        }
    }
}
