package com.example.demo.Models;

import com.example.demo.Controllers.Product.Product;
import com.example.demo.Database.DbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductsModel {
    public static List<Product> getAllProducts() throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "SELECT * FROM products";
        PreparedStatement pstm = connection.prepareStatement(sql);
        List<Product> products = new ArrayList<>();

        ResultSet rst = pstm.executeQuery();
        while (rst.next()) {
            products.add(new Product(rst.getString(1), rst.getString(2), rst.getString(3), rst.getInt(4), rst.getDouble(5)));
        }
        return products;
    }

    public static boolean deleteProduct(String productId) {
        try {
            Connection connection = DbConnection.getInstance().getConnection();
            String sql = "DELETE FROM products WHERE product_id=?";
            PreparedStatement pstm = connection.prepareStatement(sql);
            pstm.setString(1, productId);
            return pstm.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
