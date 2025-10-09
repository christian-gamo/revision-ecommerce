package com.cpg.pprojects.ecommerce.domain.category.repository;

import com.cpg.pprojects.ecommerce.domain.category.model.Category;

import java.util.Optional;

public interface ICategoryRepository {
    Optional<Category> findById(Long id);
    Category findAll();
    Category save(Category category);
    void delete(Category category);

    Category findByCategoryName(String categoryName);
}
