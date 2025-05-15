package tn.dev.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.dev.api.entities.Category;
import tn.dev.api.entities.Product;
import tn.dev.api.repositories.ProductRepository;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Override
    public Product saveProduct(Product p) {
        return productRepository.save(p);
    }

    @Override
    public Product updateProduct(Product p) {
        return productRepository.save(p);
    }

    @Override
    public Product getProductById(Long id) {
        return productRepository.findById(id).get();
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public List<Product> findByName(String name) {
        return productRepository.findByName(name);
    }

    @Override
    public List<Product> findByNameContains(String name) {
        return productRepository.findByNameContains(name);
    }

    @Override
    public List<Product> findByCategory(Category category) {
        return productRepository.findByCategory(category);
    }

    @Override
    public List<Product> findByCategoryId(Long id) {
        return productRepository.findByCategoryId(id);
    }

    @Override
    public List<Product> findByOrderByNameAsc() {
        return productRepository.findByOrderByNameAsc();
    }

    @Override
    public List<Product> findByNamePrice(String name, Double price) {
        return productRepository.findByNamePrice(name, price);
    }

    @Override
    public List<Product> findByOrderByNameAscPriceAsc() {
        return List.of();
    }

    @Override
    public List<Product> findByNameAndPrice(String name, Double price) {
        return List.of();
    }

    @Override
    public void deleteProduct(Product p) {
        productRepository.delete(p);
    }

    @Override
    public void deleteProductById(Long id) {
        productRepository.deleteById(id);
    }
}
