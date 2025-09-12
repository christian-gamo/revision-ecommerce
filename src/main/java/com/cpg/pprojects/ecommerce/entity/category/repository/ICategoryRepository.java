package com.cpg.pprojects.ecommerce.entity.category.repository;

import com.cpg.pprojects.ecommerce.entity.category.model.Category;

public interface ICategoryRepository {
    Category findById(long id);
    Category findAll();
    Category save(Category category);
    void delete(Category category);

    Category findByCategoryName(String categoryName);
}
