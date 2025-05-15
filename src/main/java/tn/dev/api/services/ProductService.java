package tn.dev.api.services;

import tn.dev.api.entities.Category;
import tn.dev.api.entities.Product;
import java.util.List;

/**
 * ✅ Advantages of an interface:
 * ✔ Allows for easy implementation changes.
 * ✔ Facilitates unit testing (you can use mocks with Mockito).
 * 🚀 This is a best practice in Spring Boot for a well-structured and scalable service!
 */
public interface ProductService {
    Product saveProduct(Product p);
    Product updateProduct(Product p);
    Product getProductById(Long id);

    void deleteProduct(Product p);
    void deleteProductById(Long id);

    List<Product> getAllProducts();
    List<Product> findByName(String name);
    List<Product> findByNameContains(String name);
    List<Product> findByCategoryId(Long id);
    List<Product> findByOrderByNameAsc();
    List<Product> findByNamePrice(String name, Double price);
    List<Product> findByCategory(Category category);
    List<Product> findByOrderByNameAscPriceAsc();
    List<Product> findByNameAndPrice(String name, Double price);
}
