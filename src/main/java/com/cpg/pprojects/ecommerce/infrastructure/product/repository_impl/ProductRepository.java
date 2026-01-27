package com.cpg.pprojects.ecommerce.infrastructure.product.repository_impl;

import com.cpg.pprojects.ecommerce.domain.product.model.Product;
import com.cpg.pprojects.ecommerce.domain.product.repository.IProductRepository;
import com.cpg.pprojects.ecommerce.domain.user.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductRepository implements IProductRepository {
    @Override
    public Optional<Product> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<Product> findAll() {
        return List.of();
    }

    @Override
    public Product save(Product product) {
        return null;
    }

    @Override
    public void delete(Product product) {

    }

    @Override
    public List<Product> findByCategoryOrderByPriceAsc(int pageNumber, int pageSize, String sortBy, String sortOrder) {
        return List.of();
    }

    @Override
    public List<Product> findByProductNameLikeIgnoreCase(String keyword, int pageNumber, int pageSize, String sortBy, String sortOrder) {
        return List.of();
    }

    @Override
    public List<Product> findByUser(User user, int pageNumber, int pageSize, String sortBy, String sortOrder) {
        return List.of();
    }
}
