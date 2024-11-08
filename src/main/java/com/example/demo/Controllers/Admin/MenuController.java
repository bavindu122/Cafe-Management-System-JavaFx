package com.example.demo.Controllers.Admin;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MenuController {

    @FXML
    private Button addLatteButton, addAmericanoButton, addCappuccinoButton, addGreenTeaButton, addHerbalTeaButton, addLemonTeaButton;

    @FXML
    private ChoiceBox<Integer> latteChoice, americanoChoice, cappuccinoChoice, greenTeaChoice, herbalTeaChoice, lemonTeaChoice;

    // Database connection details
    private final String url = "jdbc:mysql://localhost:3306/cafe_db";
    private final String user = "root";
    private final String password = "your_password";

    public void initialize() {
        // Initialize choice boxes with quantities
        Integer[] quantities = {1, 2, 3, 4, 5};
        latteChoice.getItems().addAll(quantities);
        americanoChoice.getItems().addAll(quantities);
        cappuccinoChoice.getItems().addAll(quantities);
        greenTeaChoice.getItems().addAll(quantities);
        herbalTeaChoice.getItems().addAll(quantities);
        lemonTeaChoice.getItems().addAll(quantities);
    }

    @FXML
    private void handleAddLatte(ActionEvent event) {
        addProductToDB("Latte", 10, latteChoice.getValue());
    }

    @FXML
    private void handleAddAmericano(ActionEvent event) {
        addProductToDB("Americano", 11, americanoChoice.getValue());
    }

    @FXML
    private void handleAddCappuccino(ActionEvent event) {
        addProductToDB("Cappuccino", 15, cappuccinoChoice.getValue());
    }

    @FXML
    private void handleAddGreenTea(ActionEvent event) {
        addProductToDB("Green Tea", 8, greenTeaChoice.getValue());
    }

    @FXML
    private void handleAddHerbalTea(ActionEvent event) {
        addProductToDB("Herbal Tea", 9, herbalTeaChoice.getValue());
    }

    @FXML
    private void handleAddLemonTea(ActionEvent event) {
        addProductToDB("Lemon Tea", 9, lemonTeaChoice.getValue());
    }

    private void addProductToDB(String productName, int price, int quantity) {
        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement stmt = conn.prepareStatement("INSERT INTO orders (product_name, price, quantity) VALUES (?, ?, ?)")) {
            stmt.setString(1, productName);
            stmt.setInt(2, price);
            stmt.setInt(3, quantity);
            stmt.executeUpdate();
            System.out.println("Product added: " + productName);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
