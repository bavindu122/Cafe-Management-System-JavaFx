package com.example.demo.Controllers.Product;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Product {
    private String productId;
    private String productName;
    private String productType;
    private int stock;
    private double price;

    public Product(String productId, String productName, String productType, int stock, double price) {
        this.productId = productId;
        this.productName = productName;
        this.productType = productType;
        this.stock = stock;
        this.price = price;
    }

}
