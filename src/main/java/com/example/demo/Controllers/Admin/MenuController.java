package com.example.demo.Controllers.Admin;

import com.example.demo.Controllers.Product.Product;
import com.example.demo.Models.ProductsModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class MenuController {

    public Pane MenuPane;
    public AnchorPane menu_form;
    public ScrollPane menu_scrollpane;
    public GridPane menu_gridpane;
    public ChoiceBox menu_customer;
    public Button menu_paybtn;
    public Button menu_cancelbtn;
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
        loadProductCards();
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

    public void loadProductCards() {
        List<Product> products = ProductsModel.getAllProductsWithImages();
        int column = 0;
        int row = 0;
        for (Product product : products) {
            System.out.println("Product: " + product);
            addProductCard(product, column, row);
            column++;
            if (column == 2) {
                column = 0;
                row++;
            }
        }
    }

    private void addProductCard(Product product, int column, int row) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Admin/MenuProductCard.fxml"));
            AnchorPane cardPane = loader.load();
            MenuProductCardController controller = loader.getController();
            controller.setProductDetails(product, this);
            menu_gridpane.add(cardPane, column, row);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
