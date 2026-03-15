package com.doug.categoryservice.repository;

import com.doug.categoryservice.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category,Long> {

    List<Category> findBySalonId(Long salonId);
}
