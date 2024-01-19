module kg.mega.shop {
    requires javafx.controls;
    requires javafx.fxml;


    opens kg.mega.shop to javafx.fxml;
    exports kg.mega.shop;
    exports kg.mega.shop.controllers;
    opens kg.mega.shop.controllers to javafx.fxml;
    exports kg.mega.shop.models;
    opens kg.mega.shop.models to javafx.fxml;
}