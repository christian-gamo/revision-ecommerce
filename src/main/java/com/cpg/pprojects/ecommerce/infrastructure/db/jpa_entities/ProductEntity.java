package com.cpg.pprojects.ecommerce.infrastructure.db.jpa_entities;

import com.cpg.pprojects.ecommerce.domain.product.model.Product;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "products")
@ToString
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idProduct;

    @NotBlank
    @Size(min = 3, message = "Product name must contain atleast 3 characters")
    private String productName;
    private String image;

    @NotBlank
    @Size(min = 6, message = "Product description must contain atleast 6 characters")
    private String description;
    private Integer quantity;
    private double price;
    private double discount;
    private double specialPrice;

    @ManyToOne
    @JoinColumn(name = "id_category")
    private CategoryEntity category;

    @ManyToOne
    @JoinColumn(name = "id_seller")
    private UserEntity user;

    @OneToMany(mappedBy = "product", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER)
    private List<CartItemEntity> products = new ArrayList<>();

    public ProductEntity(Product product) {
        this.idProduct = product.getIdProduct();
        this.productName = product.getProductName();
        this.image = product.getImage();
        this.description = product.getDescription();
        this.quantity = product.getQuantity();
        this.price = product.getPrice();
        this.discount = product.getDiscount();
        this.specialPrice = product.getSpecialPrice();
        this.category = new CategoryEntity(product.getCategory());
        this.user = new UserEntity(product.getUser());
    }

    public Product toProduct(){
        return new Product(
                this.idProduct,
                this.productName,
                this.description,
                this.image,
                this.quantity,
                this.price,
                this.specialPrice,
                this.discount,
                this.category.toCategory(),
                this.user.toUser()
        );
    }
}
