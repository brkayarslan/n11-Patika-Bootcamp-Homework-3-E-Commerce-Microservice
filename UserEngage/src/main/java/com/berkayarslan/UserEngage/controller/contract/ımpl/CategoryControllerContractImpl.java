package com.berkayarslan.UserEngage.controller.contract.ımpl;

import com.berkayarslan.UserEngage.controller.contract.CategoryControllerContract;
import com.berkayarslan.UserEngage.dto.CategoryDTO;
import com.berkayarslan.UserEngage.mapper.CategoryMapper;
import com.berkayarslan.UserEngage.model.Category;
import com.berkayarslan.UserEngage.request.category.CategorySaveRequest;
import com.berkayarslan.UserEngage.service.CategoryService;
import lombok.RequiredArgsConstructor;
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
