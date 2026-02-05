package com.cpg.pprojects.ecommerce.infrastructure.category.repository_impl;

import com.cpg.pprojects.ecommerce.domain.category.model.Category;
import com.cpg.pprojects.ecommerce.domain.category.repository.ICategoryRepository;
import com.cpg.pprojects.ecommerce.infrastructure.db.jpa_entities.CategoryEntity;
import com.cpg.pprojects.ecommerce.infrastructure.db.jpa_repository.ICategoryJpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Repository
public class CategoryRepository implements ICategoryRepository {

    ICategoryJpaRepository categoryJpaRepository;

    public CategoryRepository(ICategoryJpaRepository categoryRepository) {
        this.categoryJpaRepository = categoryRepository;
    }

    @Override
    public Optional<Category> findById(Long id) {
        return categoryJpaRepository.findById(id).map(CategoryEntity::toCategory);
    }

    @Override
    public List<Category> findAll() {
        List<CategoryEntity> categoryEntities = categoryJpaRepository.findAll();

        if(categoryEntities.isEmpty())
            return Collections.emptyList();

        return categoryEntities.stream().map(CategoryEntity::toCategory).toList();
    }

    @Override
    public Category save(Category category) {
        return categoryJpaRepository.save(new CategoryEntity(category)).toCategory();
    }

    @Override
    public void delete(Category category) {
        categoryJpaRepository.delete(new CategoryEntity(category));
    }

    @Override
    public Category findByCategoryName(String categoryName) {
        return categoryJpaRepository.findByCategoryName(categoryName).toCategory();
    }
}
