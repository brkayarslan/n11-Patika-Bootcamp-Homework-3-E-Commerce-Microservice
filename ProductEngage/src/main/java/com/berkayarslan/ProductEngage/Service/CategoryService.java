package com.berkayarslan.ProductEngage.Service;


import com.berkayarslan.ProductEngage.general.BaseEntityService;
import com.berkayarslan.ProductEngage.model.Category;
import com.berkayarslan.ProductEngage.repository.CategoryRepository;
import org.springframework.stereotype.Service;

@Service
public class CategoryService extends BaseEntityService<Category, CategoryRepository> {
    protected CategoryService(CategoryRepository repository) {
        super(repository);
    }
}
