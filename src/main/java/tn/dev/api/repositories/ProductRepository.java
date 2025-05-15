package tn.dev.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import tn.dev.api.entities.Category;
import tn.dev.api.entities.Product;

import java.util.List;

// The Interface JPARepository provide all function for database operations
@RepositoryRestResource(path="rest")
public interface ProductRepository extends JpaRepository<Product, Long> {

    /**
     * 💡 With Spring Data JPA, methods like findByAttributeName(String value) are based on the exact name of your entity's attributes.
     * Spring automatically generates the SQL query based on this.
     */
    List<Product> findByName(String name);
    List<Product> findByNameContains(String name);
    List<Product> findByCategoryId(Long id);
    List<Product> findByOrderByNameAsc();

    /* @Query("SELECT p FROM Product p WHERE p.name LIKE %?1 AND p.price > ?2")
    List<Product> findByNamePrice(String name, Double price); */

    @Query("SELECT p FROM Product p WHERE p.name LIKE %:name AND p.price > :price")
    List<Product> findByNamePrice(@Param("name") String name, @Param("price") Double price);

    @Query("SELECT p FROM Product p WHERE p.category = ?1")
    List<Product> findByCategory(Category category);

    @Query("SELECT p FROM Product p ORDER BY p.name ASC, p.price ASC")
    List<Product> findByOrderByNameAscPriceAsc();
}
