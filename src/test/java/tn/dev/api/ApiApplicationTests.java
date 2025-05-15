package tn.dev.api;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tn.dev.api.entities.Category;
import tn.dev.api.entities.Product;
import tn.dev.api.repositories.ProductRepository;

import java.util.Date;
import java.util.List;

@SpringBootTest
class ApiApplicationTests {

    @Autowired
    private ProductRepository productRepository; // Injective dependencies

    @Test
    public void testCreateProduct() {
        Product product = new Product(
                "Black Diamond",
                "Descendante des Blackberry et Diamond OG.",
                4.5,
                6.50,
                "https://images.squarespace-cdn.com/content/v1/604677af877639235c12b415/1647985033193-ZS8OXMY05EG6YY9E9CAX/BlackDiamond01.jpg?format=1500w",
                150,
                new Date()
            );
        productRepository.save(product);
    }

    @Test
    public void testFindProductById() {
        Product p = productRepository.findById(1L).get();
        System.out.println(p);
    }

    @Test
    public void testFindProductByName() {
        List<Product> products = productRepository.findByName("Black Diamond");
        for (Product p : products) {
            System.out.println(p);
        }
    }

    @Test
    public void testFindProductByNameContains() {
        List<Product> products = productRepository.findByNameContains("o");
        for (Product p : products) {
            System.out.println(p);
        }
    }

    @Test
    public void testUpdateProduct() {
        Product p = productRepository.findById(1L).get();
        p.setPrice(5.00);
        productRepository.save(p);
        System.out.println(p);
    }

    @Test
    public void testDeleteProductById() {
        productRepository.deleteById(4L);
    }

    @Test
    public void testFindAllProduct() {
        List<Product> products = productRepository.findAll();
        for (Product p : products) {
            System.out.println(p);
        }
    }

    @Test
    public void testFindByNamePrice() {
        List<Product> products = productRepository.findByNamePrice("Black Diamond", 5.00);
        for (Product p : products) {
            System.out.println(p);
        }
    }

    @Test
    public void testFindByCategory() {
        Category cat = new Category();
        cat.setId(1L);
        List<Product> products = productRepository.findByCategory(cat);
        for (Product p : products) {
            System.out.println(p);
        }
    }

    @Test
    public void testFindByCategoryId() {
        List<Product> products = productRepository.findByCategoryId(1L);
        for (Product p : products) {
            System.out.println(p);
        }
    }

    @Test
    public void testFindByOrderByNameAsc() {
        List<Product> products = productRepository.findByOrderByNameAsc();
        for (Product p : products) {
            System.out.println(p);
        }
    }

    @Test
    public void testFindByOrderByNameAscPriceAsc() {
        List<Product> products = productRepository.findByOrderByNameAscPriceAsc();
        for (Product p : products) {
            System.out.println(p);
        }
    }
}
