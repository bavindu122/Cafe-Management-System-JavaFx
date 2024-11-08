package com.example.demo.Controllers.Admin;

import io.github.palexdev.materialfx.controls.MFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class DashBoardFormController {
    public MFXButton btnDashboard;
    public MFXButton btnOrder;
    public MFXButton btnMenuItems;
    public MFXButton btnCustomer;
    public MFXButton btnSales;
    public MFXButton btnInventory;
    public MFXButton btnLogout;
    public AnchorPane mainPane;
    public MFXButton btnEmployee;

    public void initialize() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/Admin/dashBoardMainForm.fxml"));

        Pane registerPane = (Pane) fxmlLoader.load();
        mainPane.getChildren().clear();
        mainPane.getChildren().add(registerPane);

        //To Activate dashboard Button
        setButtonActive(btnDashboard);
    }

    @FXML
    void btnDashboardOnAction(ActionEvent event) throws IOException {
        setButtonActive(btnDashboard);
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/Admin/dashBoardMainForm.fxml"));
        Pane registerPane = (Pane) fxmlLoader.load();
        mainPane.getChildren().clear();
        mainPane.getChildren().add(registerPane);

    }

    public void btnOrderOnAction(ActionEvent actionEvent) {
    }

    @FXML
    void btnEmployeeOnAction(ActionEvent event) throws IOException {
        setButtonActive(btnEmployee);
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/Admin/employeeForm.fxml"));
        Pane registerPane = (Pane) fxmlLoader.load();
        mainPane.getChildren().clear();
        mainPane.getChildren().add(registerPane);
    }

    public void btnMenuItemsOnAction(ActionEvent actionEvent) {
    }

    public void btnCustomerOnAction(ActionEvent actionEvent) {
    }

    public void btnSalesOnAction(ActionEvent actionEvent) {
    }

    public void btnInventoryOnAction(ActionEvent actionEvent) {
    }

    public void btnLogoutOnAction(ActionEvent actionEvent) {
    }
    private void setButtonActive(MFXButton activeButton) {

        //Remove Style
        btnDashboard.getStyleClass().removeAll("mfx-active-button","mfx-button");


        btnOrder.getStyleClass().removeAll("mfx-active-button","mfx-button");
        btnSales.getStyleClass().removeAll("mfx-active-button","mfx-button");
        btnEmployee.getStyleClass().removeAll("mfx-active-button","mfx-button");
        btnCustomer.getStyleClass().removeAll("mfx-active-button","mfx-button");
        btnLogout.getStyleClass().removeAll("mfx-active-button","mfx-button");
        btnMenuItems.getStyleClass().removeAll("mfx-active-button","mfx-button");
        btnInventory.getStyleClass().removeAll("mfx-active-button","mfx-button");

        //Add Style
        activeButton.getStyleClass().add("mfx-active-button");
    }
}
