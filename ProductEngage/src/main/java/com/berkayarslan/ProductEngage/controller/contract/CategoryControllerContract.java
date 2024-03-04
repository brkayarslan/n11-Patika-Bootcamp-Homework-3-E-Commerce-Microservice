package com.berkayarslan.ProductEngage.controller.contract;



import com.berkayarslan.ProductEngage.dto.CategoryDTO;
import com.berkayarslan.ProductEngage.request.category.CategorySaveRequest;

import java.util.List;

public interface CategoryControllerContract {

    CategoryDTO saveCategory(CategorySaveRequest request);

    List<CategoryDTO> findAllCategory();

    CategoryDTO findByCategoryId(Long id);

    void deleteByCategoryId(Long id);


}
