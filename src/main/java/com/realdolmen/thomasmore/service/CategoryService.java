package com.realdolmen.thomasmore.service;


import com.realdolmen.thomasmore.domain.Category;
import com.realdolmen.thomasmore.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public void createCategory(String name, String description) {
        Category category = new Category();
        category.setName(name);
        category.setDescription(description);


        categoryRepository.save(category);
    }

    public List<Category> findAllCategories() {
        return categoryRepository.findAll();
    }

    public void deleteCategory(Long id) {
        categoryRepository.delete(id);

    }

    public Category getCategoryById(Long id) {
        return categoryRepository.findCategoryById(id);
    }

    public void updateCategory(Category category) {
        categoryRepository.save(category);
    }
}
