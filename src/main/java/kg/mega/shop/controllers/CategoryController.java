package kg.mega.shop.controllers;

import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import kg.mega.shop.models.Category;
import kg.mega.shop.services.CategoryService;

public class CategoryController {

    private CategoryService categoryService = CategoryService.INSTANCE;
    @FXML
    private ListView<Category> listViewCategories;

    @FXML
    private MenuItem menuItemAdd;

    @FXML
    private MenuItem menuItemDelete;

    @FXML
    private MenuItem menuItemEdit;

    @FXML
    void onMenuItemClicked(ActionEvent event) {
        if (event.getSource().equals(menuItemDelete)){
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION,"Вы уверены ? ", ButtonType.YES,ButtonType.NO);
            Optional<ButtonType> choice = alert.showAndWait();
            if (choice.get().equals(ButtonType.YES)){
                System.out.println("Надо удалить !");
            }else {
                System.out.println("Нечего не делать ! ");

            }
        }
    }

    @FXML
    void initialize() {
        List<Category> categories = categoryService.getCategories();
        listViewCategories.setItems(FXCollections.observableList(categories));

    }

}
