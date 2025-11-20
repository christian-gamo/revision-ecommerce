package com.cpg.pprojects.ecommerce.infrastructure.db.jpa_entities;

import com.cpg.pprojects.ecommerce.domain.category.model.Category;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity(name = "categories")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCategory;

    @NotBlank
    @Size(min = 5, message = "Category name must contain atleast 5 characters")
    private String categoryName;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private List<ProductEntity> products;

    public CategoryEntity(Category category) {
        this.idCategory = category.getIdCategory();
        this.categoryName = category.getCategoryName();
    }

    public Category toCategory(){
        return new Category(this.idCategory, this.categoryName);

    }
}
