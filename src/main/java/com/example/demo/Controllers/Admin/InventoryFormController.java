package com.example.demo.Controllers.Admin;

import com.example.demo.Controllers.Admin.Tables.ProductTable;
import com.example.demo.Controllers.Product.Product;
import com.example.demo.Models.ProductsModel;
import io.github.palexdev.materialfx.controls.MFXButton;
import io.github.palexdev.materialfx.controls.MFXFilterComboBox;
import io.github.palexdev.materialfx.controls.MFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.sql.SQLException;
import java.util.List;

public class InventoryFormController {
    public AnchorPane inventoryPane;
    public TableView tblProduct;
    public TableColumn colProductId;
    public TableColumn colProductName;
    public TableColumn colProductType;
    public TableColumn colStock;
    public TableColumn colPrice;
    public TableColumn colUpdate;
    public TableColumn colDelete;
    public MFXTextField txtSearch;
    public TextField txtProductName;
    public TextField txtProductID;
    public TextField txtStock;
    public TextField txtPrice;
    public MFXButton btnAddImage;
    public ImageView btnImport;
    public MFXButton btnProductClear;
    public MFXButton btnAddProduct;
    public ImageView imgProduct;
    public MFXFilterComboBox cmbProductType;

    public void initialize() {
        setCellValuesFactory();
        loadAllProducts();
    }

    private void setCellValuesFactory() {
        colProductId.setCellValueFactory(new PropertyValueFactory<>("productId"));
        colProductName.setCellValueFactory(new PropertyValueFactory<>("productName"));
        colProductType.setCellValueFactory(new PropertyValueFactory<>("productType"));
        colStock.setCellValueFactory(new PropertyValueFactory<>("stock"));
        colPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
        colUpdate.setCellValueFactory(new PropertyValueFactory<>("updateButton"));
        colDelete.setCellValueFactory(new PropertyValueFactory<>("deleteButton"));

    }

    public void loadAllProducts() {
        ObservableList<ProductTable> productTables = FXCollections.observableArrayList();
        try {

            List<Product> allProducts = ProductsModel.getAllProducts();
            for (Product product : allProducts) {
                productTables.add(new ProductTable(product.getProductId(), product.getProductName(), product.getProductType(), product.getStock(), product.getPrice()));
                System.out.println(product.getProductId()+" "+product.getProductName()+" "+product.getProductType()+" "+product.getStock()+" "+product.getPrice());
            }
            for (int i = 0; i < productTables.size(); i++) {
                final int index = i;
                productTables.get(i).getUpdateButton().setOnAction(event -> {
                    try {
                        updateProduct(productTables.get(index).getProductId());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });

                productTables.get(i).getDeleteButton().setOnAction(event -> {

                    ButtonType yes = new ButtonType("Yes", ButtonBar.ButtonData.OK_DONE);
                    ButtonType no = new ButtonType("No", ButtonBar.ButtonData.CANCEL_CLOSE);

                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure you want to delete this product?", yes, no);

                    if (alert.showAndWait().orElse(no) == yes) {
                        // Delete the product
                        String productId = productTables.get(index).getProductId();
                        deleteProduct(productId);
                        loadAllProducts();
                    }
                });
            }
            tblProduct.setItems(productTables);
        } catch (SQLException throwables) {
            System.out.println(throwables.getMessage());
            throwables.printStackTrace();

        }
    }
        private void updateProduct (String productId){


        }
        private void deleteProduct (String productId){
            boolean isDeleted = ProductsModel.deleteProduct(productId);
            if (isDeleted) {
                new Alert(Alert.AlertType.CONFIRMATION, "Product Deleted").show();
            }
        }


        public void txtSearchOnAction (ActionEvent actionEvent){
        }

        public void btnAddImageOnAction (ActionEvent actionEvent){
        }

        public void btnAddProductOnAction (ActionEvent actionEvent){
        }

        public void cmbProductTypeOnAction (ActionEvent actionEvent){
        }
        // This is a placeholder for the InventoryFormController class
        // This class will be used to control the InventoryForm.fxml file


    }
