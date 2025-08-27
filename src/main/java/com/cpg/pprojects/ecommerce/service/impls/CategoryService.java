package com.cpg.pprojects.ecommerce.service.impls;

import com.cpg.pprojects.ecommerce.model.Category;
import com.cpg.pprojects.ecommerce.service.interfaces.ICategoryService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService implements ICategoryService {
    private List<Category> categories = new ArrayList<>();

    @Override
    public List<Category> getCategories() {
        return categories;
    }

    @Override
    public void addCategory(Category category) {
        categories.add(category);
    }
}
