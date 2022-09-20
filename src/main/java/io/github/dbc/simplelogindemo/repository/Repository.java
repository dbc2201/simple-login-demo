package io.github.dbc.simplelogindemo.repository;

import io.github.dbc.simplelogindemo.model.User;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface Repository {
    boolean add(Connection connection, User user);

    User getByUsername(String username, Connection connection) throws SQLException;

    List<User> getAllUsers(Connection connection);

    boolean updatePassword(String username, Connection connection);

    User deleteUser(String username, Connection connection);
}
