package com.example.demo.Controllers.Admin;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;

public class MenuProductCardController {

    @FXML
    private Label prod_name;

    @FXML
    private Label prod_price;

    @FXML
    private Spinner<Integer> prod_spinner;

    @FXML
    private Button prod_addbtn;

    private MenuController menuController;

    public void setMenuController(MenuController menuController) {
        this.menuController = menuController;
    }

    @FXML
    private void initialize() {
        prod_addbtn.setOnAction(event -> {
            String name = prod_name.getText();
            int quantity = prod_spinner.getValue();
            double price = Double.parseDouble(prod_price.getText());

            menuController.addProductToTable(name, quantity, price);
        });
    }
}
