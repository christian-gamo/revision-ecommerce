package com.cpg.pprojects.ecommerce.controller;

import com.cpg.pprojects.ecommerce.model.Category;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategoryController {
    private List<Category> categories;

    @GetMapping("api/public/categories")
    public List<Category> getCategories() {
        return categories;
    }
}
