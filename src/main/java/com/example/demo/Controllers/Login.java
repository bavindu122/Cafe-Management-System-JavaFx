package com.example.demo.Controllers;

import com.example.demo.Controllers.Admin.Admin;
import com.example.demo.Models.Users;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Login {
    public TextField usernameField;
    public PasswordField passwordField;
    public Button loginButton;
    public Label error_msg;


    public void handleLogin(ActionEvent actionEvent) {
        String username = usernameField.getText();
        String password = passwordField.getText();

        System.out.println("Username: " + username);

        try {
            int result = Users.checkAdminLogin(username, password);
            if (result == 1) {
                System.out.println("Login Successful");
                Admin admin = new Admin(username, password);
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/Admin/AdminDashboard.fxml"));
                Parent parent = fxmlLoader.load();
                Scene scene = new Scene(parent);
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.centerOnScreen();
                stage.show();

                Stage loginStage = (Stage) usernameField.getScene().getWindow();
                loginStage.close();

            } else if (result == 2) {
                System.out.println("Incorrect Password");
                error_msg.setText("Incorrect Password");
            } else if (result == 0) {
                result = Users.checkEmployeeLogin(username, password);
                if (result == 1) {
                    System.out.println("Login Successful");
                } else if (result == 0) {
                    System.out.println("Username does not exist");
                    error_msg.setText("Username does not exist");
                } else if (result == 2) {
                    System.out.println("Incorrect Password");
                    error_msg.setText("Incorrect Password");
                }
            }
        } catch (Exception e) {
            System.out.println("Login Failed");
            System.out.println(e.getMessage());
        }
    }

    public void handleForgotPassword(ActionEvent actionEvent) {
        System.out.println("Forgot Password");
    }
}
