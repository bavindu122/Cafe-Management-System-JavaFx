package com.example.demo.Models;

import com.example.demo.Database.DbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Users {

    public static String username;

    // This method is used to check if the Admin username exists in the database
    static boolean checkAdminUserName(String username) {
        try {
            Connection connection = DbConnection.getInstance().getConnection();
            String sql = "SELECT * FROM admin WHERE name=?";
            PreparedStatement pstm = connection.prepareStatement(sql);
            pstm.setString(1, username);
            return pstm.executeQuery().next();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //This method is used to check if the Admin username and password match
    public static int checkAdminLogin(String username, String password) {
        try {
           if(checkAdminUserName(username)){
               Connection connection = DbConnection.getInstance().getConnection();
               String sql = "SELECT * FROM admin WHERE name=? AND password=?";
               PreparedStatement pstm = connection.prepareStatement(sql);
               pstm.setString(1, username);
               pstm.setString(2, password);
                return pstm.executeQuery().next() ? 1 : 2;
           }else {
               return 0;
           }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //This method is used to check if the Employee username exists in the database
    static boolean checkEmployeeUserName(String username) {
        try {
            Connection connection = DbConnection.getInstance().getConnection();
            String sql = "SELECT * FROM employee WHERE name=?";
            PreparedStatement pstm = connection.prepareStatement(sql);
            pstm.setString(1, username);
            return pstm.executeQuery().next();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //This method is used to check if the Employee username and password match
    public static int checkEmployeeLogin(String username, String password) {
        try {
           if(checkEmployeeUserName(username)){
               Connection connection = DbConnection.getInstance().getConnection();
               String sql = "SELECT * FROM employee WHERE name=? AND password=?";
               PreparedStatement pstm = connection.prepareStatement(sql);
               pstm.setString(1, username);
               pstm.setString(2, password);
                return pstm.executeQuery().next() ? 1 : 2;
           }else {
               return 0;
           }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
