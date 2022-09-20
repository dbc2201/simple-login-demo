package io.github.dbc.simplelogindemo;

import io.github.dbc.simplelogindemo.model.User;
import io.github.dbc.simplelogindemo.repository.UserRepository;
import io.github.dbc.simplelogindemo.service.DatabaseService;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.sql.SQLException;

public class HelloController {
    DatabaseService databaseService;
    UserRepository userRepository;

    @FXML
    public TextField usernameField;

    @FXML
    public PasswordField passwordField;

    @FXML
    public Button loginButton;

    @FXML
    public boolean logIn() {

        this.databaseService = new DatabaseService();
        this.userRepository = new UserRepository();
        this.databaseService.connect();

        User user = new User();

        String username = usernameField.getText().trim();
        String password = passwordField.getText().trim();

        try {
            user = userRepository.getByUsername(username, this.databaseService.getConnection());
            if (username.equals(user.getUsername()) && password.equals(user.getPassword())) {
                Alert alert = new Alert(
                        Alert.AlertType.CONFIRMATION,
                        "Welcome, " + username
                );
                alert.show();
                return true;
            }
        } catch (SQLException e) {
            System.err.println("could not find the user!");
            return false;
        }

        return false;
    }
}