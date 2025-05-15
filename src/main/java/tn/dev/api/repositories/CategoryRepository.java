package tn.dev.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import tn.dev.api.entities.Category;

import java.util.List;

@RepositoryRestResource(path="categories")
// Allowing cross-origin requests from Angular application
// Skipping CORS Errors
@CrossOrigin(origins = "http://localhost:4200/")
public interface CategoryRepository extends JpaRepository<Category, Long> {
    List<Category> findByName(String name);
}

