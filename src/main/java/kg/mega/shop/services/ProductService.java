package kg.mega.shop.services;

import kg.mega.shop.models.Product;
import kg.mega.shop.services.impl.ProductServiceImpl;

import java.util.List;

public interface ProductService {
    ProductServiceImpl INSTANCE = new ProductServiceImpl();
    List<Product> getProducts();

    Product findProductBYBarcode(String barcode);
}
