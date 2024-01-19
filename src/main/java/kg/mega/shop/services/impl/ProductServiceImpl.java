package kg.mega.shop.services.impl;

import kg.mega.shop.models.Category;
import kg.mega.shop.models.Product;
import kg.mega.shop.services.CategoryService;
import kg.mega.shop.services.ProductService;

import java.util.ArrayList;
import java.util.List;

public class ProductServiceImpl implements ProductService {
    private List<Product> products = new ArrayList<>();
    private CategoryService categoryService = CategoryService.INSTANCE;

    public ProductServiceImpl() {
        products.add(new Product(1,"Веселый молочник",70,1,categoryService.findCategoryBYId(1),"123456"));
        products.add(new Product(2,"Мыло",30,1,categoryService.findCategoryBYId(2),"456789"));
    }

    @Override
    public List<Product> getProducts() {
        return products;
    }

    @Override
    public Product findProductBYBarcode(String barcode) {
        for (Product product:products) {
            if (product.getBarcode().equals(barcode.trim())){
                return product;
            }
        }
        return null;
    }
}
