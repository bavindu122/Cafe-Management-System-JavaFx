package com.example.demo.Controllers.Employee;

import com.example.demo.Controllers.Admin.Admin;
import com.example.demo.Models.SalesModel;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.util.Duration;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DashBoardMainFormController {
    public PieChart chartProduction;
    public Text txtUser;
    public AnchorPane mainPane;
    public Text txtOrders;
    public Text txtDate;
    public Text txtSales;
    public Text txtCustomers;
    @FXML
    private Text txtTime;

    public void initialize() {
        updateTime();
        sentName(Admin.getName());
        updateDate();
        txtSales.setText("Rs."+String.valueOf(SalesModel.getAllSalesAmount())+"0");
    }
    private void sentName(String name) {
        txtUser.setText(name);
    }
    private void updateDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM dd, yyyy");
        LocalDate currentDate = LocalDate.now();
        String formattedDate = currentDate.format(formatter);
        txtDate.setText(formattedDate);
    }

    private void updateTime() {
        Timeline timeline = new Timeline(new KeyFrame(Duration.ZERO, e -> {
            txtTime.setText(timeNow());

        }),
                new KeyFrame(Duration.seconds(1)));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

    private String timeNow() {
        SimpleDateFormat dateFormat=new SimpleDateFormat("hh:mm:ss a");
        return dateFormat.format(new Date()) ;
    }




}
