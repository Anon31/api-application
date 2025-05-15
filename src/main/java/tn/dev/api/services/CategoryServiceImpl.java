package tn.dev.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.dev.api.entities.Category;
import tn.dev.api.repositories.CategoryRepository;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Category getCategoryById(Long id) {
        return categoryRepository.findById(id).orElse(null);
    }

    @Override
    public Category saveCategory(Category c) {
        return categoryRepository.save(c);
    }

    @Override
    public Category updateCategory(Category c) {
        return categoryRepository.save(c);
    }

    @Override
    public void deleteCategory(Category c) {
        categoryRepository.delete(c);
    }

    @Override
    public void deleteCategoryById(Long id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public List<Category> findByName(String name) {
        return categoryRepository.findByName(name);
    }
}
