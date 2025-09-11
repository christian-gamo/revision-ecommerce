package com.cpg.pprojects.ecommerce.entity.category.model;

import com.cpg.pprojects.ecommerce.entity.product.model.Product;

import java.util.List;

public class Category {
    private long idCategory;
    private String categoryName;

    private List<Product> products;

    public Category(Long idCategory, String categoryName, List<Product> products) {
        this.idCategory = idCategory;
        this.categoryName = categoryName;
    }

    public Category() {}

    public Long getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(Long idCategory) {
        this.idCategory = idCategory;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public List<Product> getProducts() {return products;}

    public void setProducts(List<Product> products) { this.products = products; }
}
