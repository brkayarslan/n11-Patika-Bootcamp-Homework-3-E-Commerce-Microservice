package com.berkayarslan.UserEngage.repository;

import com.berkayarslan.UserEngage.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Long> {
}
