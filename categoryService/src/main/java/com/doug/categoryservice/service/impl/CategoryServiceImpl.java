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
        Category category1 = new Category();
        category1.setName(category.getName());
        category1.setSalonId(category.getSalonId());
        category1.setImage(category.getImage());
        return categoryRepository.save(category1);
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
