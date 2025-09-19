package com.cpg.pprojects.ecommerce.model.category.repository;

import com.cpg.pprojects.ecommerce.model.category.model.Category;

public interface ICategoryRepository {
    Category findById(long id);
    Category findAll();
    Category save(Category category);
    void delete(Category category);

    Category findByCategoryName(String categoryName);
}
