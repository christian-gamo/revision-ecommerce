package com.cpg.pprojects.ecommerce.infrastructure.db.jpa_repository;

import com.cpg.pprojects.ecommerce.infrastructure.db.jpa_entities.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryJpaRepository extends JpaRepository<CategoryEntity, Long> {
    CategoryEntity findByCategoryName(String categoryName);
}
