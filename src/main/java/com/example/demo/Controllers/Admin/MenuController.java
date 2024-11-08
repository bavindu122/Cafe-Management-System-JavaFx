package com.example.demo.Controllers.Admin;

import com.example.demo.Controllers.Product.Product;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

public class MenuController {

    public Pane MenuPane;
    @FXML
    private TableView<Product> menu_tableview;

    @FXML
    private TableColumn<Product, String> menu_col_productname;

    @FXML
    private TableColumn<Product, Integer> menu_col_quantity;

    @FXML
    private TableColumn<Product, Double> menu_col_price; // Unit price for each product

    @FXML
    private Label menu_total; // Total of all products in Rs.

    @FXML
    private TextField menu_amount; // Customer payment input

    @FXML
    private Label menu_change; // Change displayed here

    private ObservableList<Product> productList = FXCollections.observableArrayList();

    @FXML
    private void initialize() {
        // Map columns to Product fields
        menu_col_productname.setCellValueFactory(new PropertyValueFactory<>("productName"));
        menu_col_quantity.setCellValueFactory(new PropertyValueFactory<>("stock")); // stock represents quantity here
        menu_col_price.setCellValueFactory(new PropertyValueFactory<>("price")); // price represents unit price

        menu_tableview.setItems(productList);

        menu_amount.textProperty().addListener((observable, oldValue, newValue) -> calculateChange());
    }

    public void addProductToTable(String productName, int quantity, double unitPrice) {
        Product product = new Product(null, productName, null, quantity, unitPrice);
        productList.add(product);
        calculateTotal();
    }

    private void calculateTotal() {
        double total = productList.stream()
                .mapToDouble(product -> product.getStock() * product.getPrice()) // Calculate total as qty * unit price
                .sum();
        menu_total.setText("Rs. " + String.format("%.2f", total));
        calculateChange();
    }

    private void calculateChange() {
        try {
            double amount = Double.parseDouble(menu_amount.getText());
            double total = productList.stream()
                    .mapToDouble(product -> product.getStock() * product.getPrice())
                    .sum();
            double change = amount - total;
            menu_change.setText("Rs. " + String.format("%.2f", change));
        } catch (NumberFormatException e) {
            menu_change.setText("Rs. 0.00");
        }
    }
}
