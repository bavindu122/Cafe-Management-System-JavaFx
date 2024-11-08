package com.example.demo.Controllers.Admin;

import io.github.palexdev.materialfx.controls.MFXButton;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.chart.PieChart;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.util.Duration;

import java.io.IOException;
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
    @FXML
    private Text txtTime;

    public void initialize() {
        updateTime();
        sentName(Admin.getName());
        updateDate();
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
        Timeline timeline = new Timeline(new KeyFrame(javafx.util.Duration.ZERO, e -> {
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
