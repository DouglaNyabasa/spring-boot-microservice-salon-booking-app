package com.doug.categoryservice.controller;

import com.doug.categoryservice.models.Category;
import com.doug.categoryservice.service.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/api/categories")
public class Controller {

    private final CategoryService categoryService;

    public Controller(CategoryService categoryService) {
        this.categoryService = categoryService;
    }


    @PostMapping("/create")
    @GetMapping("/salon/{id}")
    public ResponseEntity<Set<Category>> getCategoriesBySalon(@PathVariable Long id){
        Set<Category> categories = categoryService.getAllCategoriesBySalon(id);

        return ResponseEntity.ok(categories);
    }

}
