package com.cpg.pprojects.ecommerce.service.interfaces;

import com.cpg.pprojects.ecommerce.entity.category.model.Category;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ICategoryService {
    List<Category> getCategories();
    void addCategory(Category category);

}
