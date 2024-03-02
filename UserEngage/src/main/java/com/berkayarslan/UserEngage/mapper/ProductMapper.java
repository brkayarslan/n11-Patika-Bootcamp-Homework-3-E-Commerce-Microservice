package com.berkayarslan.UserEngage.mapper;

import com.berkayarslan.UserEngage.dto.ProductDTO;
import com.berkayarslan.UserEngage.model.Product;
import com.berkayarslan.UserEngage.request.product.ProductBatchUpdateRequest;
import com.berkayarslan.UserEngage.request.product.ProductSaveRequest;
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
