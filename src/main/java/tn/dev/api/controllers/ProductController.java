package tn.dev.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import tn.dev.api.services.ProductService;
import tn.dev.api.entities.Product;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/all") // @RequestMapping(path="all", method = RequestMethod.GET)
    public List<Product> getAllProducts() { return productService.getAllProducts(); };

    @GetMapping("/getById/{id}") // @RequestMapping(value="/getById/{id}", method = RequestMethod.GET)
    public Product getProductById(@PathVariable("id") Long id) { return productService.getProductById(id); };

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/create") // @RequestMapping(value="/create", method = RequestMethod.POST)
    public Product createProduct(@RequestBody Product product) { return productService.saveProduct(product); };

    @PreAuthorize("hasAuthority('ADMIN')")
    @PutMapping("/update") // @RequestMapping(value="/update", method = RequestMethod.PUT)
    public Product updateProduct(@RequestBody Product product) {
        return productService.updateProduct(product);
    };

    @PreAuthorize("hasAuthority('ADMIN')")
    @DeleteMapping("/delete/{id}") // @RequestMapping(value="/delete/{id}", method = RequestMethod.DELETE)
    public void deleteProductById(@PathVariable("id") Long id) {
        productService.deleteProductById(id);
    };

    @GetMapping("/category/{id}") // @RequestMapping(value="/category/{id}", method = RequestMethod.GET)
    public List<Product> getAllProductsByCategory(@PathVariable("id") Long id) {
        return productService.findByCategoryId(id);
    };

    @GetMapping("/prodsByName/{name}") // @RequestMapping(value="/prodsByName/{name}", method = RequestMethod.GET)
    public List<Product> findByNameContains(@PathVariable("name") String name) {
        return productService.findByNameContains(name);
    };
}
