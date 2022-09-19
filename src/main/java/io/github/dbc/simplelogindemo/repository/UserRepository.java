package io.github.dbc.repository;

import io.github.dbc.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserRepository implements Repository {
    // CRUD methods

    @Override
    public boolean add(Connection connection, User user) {
        return false;
    }

    @Override
    public User getByUsername(String username, Connection connection) throws SQLException {
        User user = new User();
        String searchQuery = "SELECT * FROM `users`.`user` WHERE `username` = ?;";
        try (PreparedStatement preparedStatement = connection.prepareStatement(searchQuery)) {
            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String currentUsername = resultSet.getString("username");
                String password = resultSet.getString("password");
                user = new User(currentUsername, password);
            }
        }
        return user;
    }

    @Override
    public List<User> getAllUsers(Connection connection) {
        return List.of();
    }

    @Override
    public boolean updatePassword(String username, Connection connection) {
        return false;
    }

    @Override
    public User deleteUser(String username, Connection connection) {
        return new User();
    }
}
