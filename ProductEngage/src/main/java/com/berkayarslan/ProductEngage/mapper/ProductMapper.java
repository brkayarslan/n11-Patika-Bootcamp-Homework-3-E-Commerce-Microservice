package com.berkayarslan.ProductEngage.mapper;


import com.berkayarslan.ProductEngage.dto.ProductDTO;
import com.berkayarslan.ProductEngage.model.Product;
import com.berkayarslan.ProductEngage.request.product.ProductSaveRequest;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProductMapper {

    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    Product productDTOToProduct(ProductSaveRequest request);

    ProductDTO productToProductDTO(Product product);

    List<ProductDTO> productListToProductDTOList(List<Product> all);

    List<Product> ProductDTOListToProductList(List<ProductSaveRequest> request);
}
