package kg.mega.shop.services;

import kg.mega.shop.models.Category;
import kg.mega.shop.services.impl.CategoryServiceImpl;

import java.util.List;

public interface CategoryService {

    CategoryServiceImpl INSTANCE = new CategoryServiceImpl();
    boolean createCategory(Category category);
    List<Category> getCategories();

    Category findCategoryBYId(int id);
}
