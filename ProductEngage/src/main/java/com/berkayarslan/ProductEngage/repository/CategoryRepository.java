package com.berkayarslan.ProductEngage.repository;


import com.berkayarslan.ProductEngage.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Long> {
}
