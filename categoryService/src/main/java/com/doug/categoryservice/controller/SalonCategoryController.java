package com.doug.categoryservice.controller;

import com.doug.categoryservice.models.Category;
import com.doug.categoryservice.payload.SalonDT0;
import com.doug.categoryservice.service.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/api/categories/salon-owner")
public class SalonCategoryController {


    private final CategoryService categoryService;

    public SalonCategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping("/create")
    public ResponseEntity<Category> createCategory(@RequestBody Category category){

        SalonDT0 salonDT0 = new SalonDT0();
        salonDT0.setId(1L);

        Category savedCategory = categoryService.createCategory(category, salonDT0);

        return ResponseEntity.ok(savedCategory);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable Long id) throws Exception {

        SalonDT0 salonDT0 = new SalonDT0();
        salonDT0.setId(1L);

         categoryService.deleteCategoryById(id, salonDT0.getId());

         return ResponseEntity.ok("category successfully deleted");
    }
}
