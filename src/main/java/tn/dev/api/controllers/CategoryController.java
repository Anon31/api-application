package tn.dev.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.dev.api.entities.Category;
import tn.dev.api.services.CategoryService;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
@CrossOrigin
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Category> getAllCategories() {
        return categoryService.getAllCategories();
    };

    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    public Category getCategoryById(@PathVariable("id") Long id) {
        return categoryService.getCategoryById(id);
    };

}
