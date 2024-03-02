package com.berkayarslan.UserEngage.controller.contract;

import com.berkayarslan.UserEngage.dto.ProductDTO;
import com.berkayarslan.UserEngage.request.product.ProductBatchUpdateRequest;
import com.berkayarslan.UserEngage.request.product.ProductSaveRequest;

import java.time.LocalDateTime;
import java.util.List;

public interface ProductControllerContract {

    ProductDTO saveProduct(ProductSaveRequest request);

    List<ProductDTO> findAllProducts();

    ProductDTO findProductById(Long id);

    List<ProductDTO> findProductsByCategoryId(Long id);

    List<ProductDTO> findAllProductsByExpirationDateLE(LocalDateTime dateTime);

    ProductDTO updateProductPrice(Long id, Double price);

    List<ProductDTO> batchUpdateProductPrice(List<ProductBatchUpdateRequest> request);

    ProductDTO activateProduct(Long id);

    ProductDTO deactivateProduct(Long id);

    void saveAllProduct(List<ProductSaveRequest> request);
}
