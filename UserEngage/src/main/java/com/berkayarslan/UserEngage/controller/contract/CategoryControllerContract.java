package com.berkayarslan.UserEngage.controller.contract;

import com.berkayarslan.UserEngage.dto.CategoryDTO;
import com.berkayarslan.UserEngage.request.category.CategorySaveRequest;

import java.util.List;

public interface CategoryControllerContract {

    CategoryDTO saveCategory(CategorySaveRequest request);

    List<CategoryDTO> findAllCategory();

    CategoryDTO findByCategoryId(Long id);

    void deleteByCategoryId(Long id);


}
