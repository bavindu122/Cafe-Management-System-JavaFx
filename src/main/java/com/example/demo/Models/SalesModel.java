package com.example.demo.Models;

import com.example.demo.Controllers.Employee.Employee;
import com.example.demo.Controllers.Sale.Sale;
import com.example.demo.Database.DbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class SalesModel {

    public static String generateNextSaleId() {
        try {
            Connection connection = DbConnection.getInstance().getConnection();
            String sql = "SELECT sale_id FROM sales ORDER BY sale_id DESC LIMIT 1";
            PreparedStatement pstm = connection.prepareStatement(sql);
            ResultSet rst = pstm.executeQuery();
            if (rst.next()) {
                String lastId = rst.getString(1);
                int newId = Integer.parseInt(lastId.substring(1)) + 1;
                if (newId < 10) {
                    return "S00" + newId;
                } else if (newId < 100) {
                    return "S0" + newId;
                } else {
                    return "S" + newId;
                }
            } else {
                return "S001";
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static boolean addSale(Sale sale) {
        try {
            Connection connection = DbConnection.getInstance().getConnection();
            String sql = "INSERT INTO sales VALUES(?,?,?,?,?)";
            PreparedStatement pstm = connection.prepareStatement(sql);
            pstm.setString(1, sale.getSaleId());
            pstm.setString(2, sale.getCusName());
            pstm.setString(3, sale.getCusContact());
            pstm.setDouble(4, sale.getTotal());
            pstm.setDate(5, new java.sql.Date(sale.getDate().getTime()));
            return pstm.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    // method to get all sales amount
    public static Double getAllSalesAmount() {
        try {
            Connection connection = DbConnection.getInstance().getConnection();
            String sql = "SELECT SUM(total) FROM sales";
            PreparedStatement pstm = connection.prepareStatement(sql);
            ResultSet rst = pstm.executeQuery();
            if (rst.next()) {
                return rst.getDouble(1);
            } else {
                return (double) 0;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    // method to get all sales details
    public static List<Sale> getAllSales() {
        List<Sale> salesList = new ArrayList<>();
        try {
            Connection connection = DbConnection.getInstance().getConnection();
            String sql = "SELECT * FROM sales";
            PreparedStatement pstm = connection.prepareStatement(sql);
            ResultSet rst = pstm.executeQuery();

            while (rst.next()) {
                Sale sale = new Sale(rst.getString(1), rst.getString(2), rst.getString(3), rst.getDouble(4), rst.getDate(5));
                salesList.add(sale);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return salesList;
    }
}
