package com.doug.categoryservice.service;

import com.doug.categoryservice.models.Category;
import com.doug.categoryservice.payload.SalonDT0;


import java.util.Set;

public interface CategoryService {

    Category createCategory(Category category, SalonDT0 salonDTO);
    Set<Category> getAllCategoriesBySalon(Long id);
    Category getCategoryById(Long id);
    void deleteCategoryById(Long id);
}
