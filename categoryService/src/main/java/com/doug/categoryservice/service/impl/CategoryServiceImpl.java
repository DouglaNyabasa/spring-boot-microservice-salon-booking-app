package com.doug.categoryservice.service.impl;

import com.doug.categoryservice.models.Category;
import com.doug.categoryservice.payload.SalonDT0;
import com.doug.categoryservice.repository.CategoryRepository;
import com.doug.categoryservice.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category createCategory(Category category, SalonDT0 salonDTO) {
        return null;
    }

    @Override
    public Set<Category> getAllCategoriesBySalon(Long id) {
        return Set.of();
    }

    @Override
    public Category getCategoryById(Long id) {
        return null;
    }

    @Override
    public void deleteCategoryById(Long id) {

    }
}
