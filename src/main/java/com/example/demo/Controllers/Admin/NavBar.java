package com.example.demo.Controllers.Admin;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;

public class NavBar {
    public Button notificationsBtn;
    public Button profileBtn;
    public Button logoutBtn;
    public Button settingsBtn;
    public Button reportsBtn;
    public Button employeesBtn;
    public Button menuBtn;
    public Button ordersBtn;
    public Button dashboardBtn;

    public void goToMenuItems(ActionEvent actionEvent) {
        System.out.println("GoToMenuItems");
    }
    public void goToOrders(ActionEvent actionEvent) {
        System.out.println("GoToOrders");
    }
    public void goToEmployees(ActionEvent actionEvent) {
        System.out.println("GoToEmployees");
    }
    public void goToReports(ActionEvent actionEvent) {
        System.out.println("GoToReports");
    }
    public void goToSettings(ActionEvent actionEvent) {
        System.out.println("GoToSettings");
    }
    public void goToProfile(ActionEvent actionEvent) {
        System.out.println("GoToProfile");
    }
    public void goToNotifications(ActionEvent actionEvent) {
        System.out.println("GoToNotifications");
    }
    public void goToDashboard(ActionEvent actionEvent) {
        System.out.println("GoToDashboard");
    }
    public void GoToLogout(ActionEvent actionEvent) {
        System.out.println("GoToLogout");
    }
}
