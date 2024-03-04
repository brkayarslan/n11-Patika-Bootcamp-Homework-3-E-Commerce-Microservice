package com.berkayarslan.ProductEngage.controller.contract.impl;

import com.berkayarslan.ProductEngage.Service.CategoryService;
import com.berkayarslan.ProductEngage.controller.contract.CategoryControllerContract;

import com.berkayarslan.ProductEngage.dto.CategoryDTO;
import com.berkayarslan.ProductEngage.mapper.CategoryMapper;
import com.berkayarslan.ProductEngage.model.Category;
import com.berkayarslan.ProductEngage.request.category.CategorySaveRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryControllerContractImpl implements CategoryControllerContract {

    private CategoryService categoryService;

    public CategoryControllerContractImpl(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @Override
    public CategoryDTO saveCategory(CategorySaveRequest request) {
        Category category = CategoryMapper.INSTANCE.CategoryDTOToCategory(request);
        categoryService.save(category);
        return CategoryMapper.INSTANCE.CategoryToCategoryDTO(category);
    }

    @Override
    public List<CategoryDTO> findAllCategory() {
        return CategoryMapper.INSTANCE.categoryListToCategoryDTOList(categoryService.findAll());
    }

    @Override
    public CategoryDTO findByCategoryId (Long id) {
        Category category = categoryService.findByIdWithControl(id);
        return CategoryMapper.INSTANCE.CategoryToCategoryDTO(category);
    }

    @Override
    public void deleteByCategoryId (Long id) {
        categoryService.delete(id);
    }
}
