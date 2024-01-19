package kg.mega.shop.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import kg.mega.shop.HelloApplication;
import kg.mega.shop.models.CustomerProduct;
import kg.mega.shop.models.Product;
import kg.mega.shop.services.ProductService;

public class MainController {
    private ProductService productService = ProductService.INSTANCE;
    List<CustomerProduct> customerProducts = new ArrayList<>();

    @FXML
    private TableColumn<String, String> colmAmount;

    @FXML
    private TableColumn<String, String> colmCategory;

    @FXML
    private TableColumn<String, String> colmName;

    @FXML
    private TableColumn<String, String> colmPrice;

    @FXML
    private TableColumn<String, String> colmTotalPrice;

    @FXML
    private TableView<CustomerProduct> tbCustomerProducts;

    @FXML
    private TextField txtBarcode;

    @FXML
    private TextField txtName;

    @FXML
    private Button btnSearch;

    @FXML
    private Label lblTotal;

    @FXML
    private TextField txtPrice;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private MenuItem menuItemCategory;

    @FXML
    private MenuItem menuItemProducts;

    @FXML
    void onSearchButtonClicked(ActionEvent event) {
        String barcode = txtBarcode.getText();

        Product product = productService.findProductBYBarcode(barcode);
        if (product == null){
            System.out.println("Товар не найден !");
            return;
        }

            txtName.setText(product.getName());
            txtPrice.setText(String.valueOf(product.getPrice()));

            CustomerProduct customerProduct = getCustomerProductOrCreate(product);

            tbCustomerProducts.refresh();

            double total = getTotalPriceFromCustomerProducts();
            lblTotal.setText(String.valueOf(total));

    }

    private double getTotalPriceFromCustomerProducts() {
        double total = 0;
        for (CustomerProduct item :customerProducts) {
            total+=item.getTotalPrice();
        }
        return total;
    }

    private CustomerProduct getCustomerProductOrCreate(Product product) {
        CustomerProduct customerProduct = null;
        for (CustomerProduct item : customerProducts) {
            if (item.getProductId() == product.getId()){
                customerProduct = item;
                customerProduct.setAmount(customerProduct.getAmount()+1);
                break;
            }
        }
        if (customerProduct == null){
            customerProduct = new CustomerProduct();

            customerProduct.setName(product.getName());
            customerProduct.setCategory(product.getCategory().getName());
            customerProduct.setAmount(product.getAmount());
            customerProduct.setPrice(product.getPrice());
            customerProduct.setProductId(product.getId());
            customerProducts.add(customerProduct);
        }
        customerProduct.setTotalPrice(customerProduct.getPrice()*customerProduct.getAmount());
        return customerProduct;
    }

    @FXML
    void onMenuItemClicked(ActionEvent event) {
        if (event.getSource().equals(menuItemCategory)){
            Stage stage = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("category-view.fxml"));
            Scene scene = null;
            try {
                scene = new Scene(fxmlLoader.load());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            stage.setTitle("Категории");
            stage.setScene(scene);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setResizable(false);
            stage.show();
        }
    }

    @FXML
    void initialize() {
        colmName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colmAmount.setCellValueFactory(new PropertyValueFactory<>("amount"));
        colmCategory.setCellValueFactory(new PropertyValueFactory<>("category"));
        colmPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
        colmTotalPrice.setCellValueFactory(new PropertyValueFactory<>("totalPrice"));
        tbCustomerProducts.setItems(FXCollections.observableList(customerProducts));
    }

}
