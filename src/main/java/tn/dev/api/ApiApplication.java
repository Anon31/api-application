package tn.dev.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import tn.dev.api.entities.Category;
import tn.dev.api.entities.Product;

@SpringBootApplication
public class ApiApplication implements CommandLineRunner {

    @Autowired // Dependencies injection
    private RepositoryRestConfiguration repositoryRestConfiguration;

    public static void main(String[] args) {
        SpringApplication.run(ApiApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // This method is executed after the application context is loaded.
        // You can add any initialization code here if needed.
        repositoryRestConfiguration.exposeIdsFor(Product.class, Category.class);
    }
}
