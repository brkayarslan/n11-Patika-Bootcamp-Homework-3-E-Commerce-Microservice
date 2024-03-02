package com.berkayarslan.UserEngage.mapper;


import com.berkayarslan.UserEngage.dto.CategoryDTO;
import com.berkayarslan.UserEngage.model.Category;
import com.berkayarslan.UserEngage.request.category.CategorySaveRequest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CategoryMapper {
    
    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

    Category CategoryDTOToCategory(CategorySaveRequest request);

    CategoryDTO CategoryToCategoryDTO(Category category);

    List<CategoryDTO> categoryListToCategoryDTOList(List<Category> all);
}
