package com.cpg.pprojects.ecommerce.entity.product.repository;

import com.cpg.pprojects.ecommerce.entity.product.model.Product;
import com.cpg.pprojects.ecommerce.entity.user.model.User;

import java.util.List;

public interface IProductRepository {
    Product findById(long id);
    List<Product> findAll();
    Product save(Product product);
    void delete(Product product);

    List<Product> findByCategoryOrderByPriceAsc(
            int pageNumber,
            int pageSize,
            String sortBy,
            String sortOrder
    );

    List<Product> findByProductNameLikeIgnoreCase(
            String keyword,
            int pageNumber,
            int pageSize,
            String sortBy,
            String sortOrder
    );

    List<Product> findByUser(
            User user,
            int pageNumber,
            int pageSize,
            String sortBy,
            String sortOrder
    );
}
