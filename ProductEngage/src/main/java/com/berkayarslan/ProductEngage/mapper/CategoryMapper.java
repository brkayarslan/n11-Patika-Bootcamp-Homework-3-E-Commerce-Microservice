package com.berkayarslan.ProductEngage.mapper;



import com.berkayarslan.ProductEngage.dto.CategoryDTO;
import com.berkayarslan.ProductEngage.model.Category;
import com.berkayarslan.ProductEngage.request.category.CategorySaveRequest;
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
