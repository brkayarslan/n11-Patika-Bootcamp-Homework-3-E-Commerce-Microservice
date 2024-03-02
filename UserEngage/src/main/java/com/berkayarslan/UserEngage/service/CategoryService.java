package com.berkayarslan.UserEngage.service;

import com.berkayarslan.UserEngage.general.BaseEntityService;
import com.berkayarslan.UserEngage.model.Category;
import com.berkayarslan.UserEngage.repository.CategoryRepository;
import org.springframework.stereotype.Service;

@Service
public class CategoryService extends BaseEntityService<Category, CategoryRepository> {
    protected CategoryService(CategoryRepository repository) {
        super(repository);
    }
}
