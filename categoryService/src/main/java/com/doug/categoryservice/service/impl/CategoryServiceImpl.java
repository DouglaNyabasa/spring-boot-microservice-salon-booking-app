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
        return categoryRepository.findBySalonId(id);
    }

    @Override
    public Category getCategoryById(Long id) throws Exception {
        Category category = categoryRepository.findById(id).orElse(null);

        if (category == null){
            throw new Exception("category does not exist with the provided id :" + id);
        }
        return category;
    }

    @Override
    public void deleteCategoryById(Long id,Long salonId) throws Exception {

       Category category = getCategoryById(id);
       if (category.getSalonId().equals(salonId)){
           throw new Exception("uou do not have permission to delete this category");
       }
        categoryRepository.deleteById(id);

    }
}
