package tn.dev.api.services;

import tn.dev.api.entities.Category;

import java.util.List;

public interface CategoryService {
    Category saveCategory(Category c);
    Category updateCategory(Category c);
    Category getCategoryById(Long id);

    void deleteCategory(Category c);
    void deleteCategoryById(Long id);

    List<Category> getAllCategories();
    List<Category> findByName(String name);
}
