package tn.dev.api.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private Double rating;
    private Double price;
    private String image;
    private int quantity;
    private Date createdDate;
    @ManyToOne
    private Category category;

    // Constructor
    public Product() {
        super();
    }

    public Product(String name, String description, Double rating, Double price, String image, int quantity, Date createdDate) {
        super();
        this.name = name;
        this.description = description;
        this.rating = rating;
        this.price = price;
        this.image = image;
        this.quantity = quantity;
        this.createdDate = createdDate;
    }

    // Getters & Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getRating() { return rating; }

    public void setRating(Double rating) { this.rating = rating; }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getquantity() {
        return quantity;
    }

    public void setquantity(int quantity) {
        this.quantity = quantity;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", rating=" + rating +
                ", price=" + price +
                ", image='" + image + '\'' +
                ", quantity=" + quantity +
                ", createdDate=" + createdDate +
                '}';
    }
}
