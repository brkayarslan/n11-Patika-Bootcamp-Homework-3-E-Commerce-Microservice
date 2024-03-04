package com.berkayarslan.ProductEngage.controller.contract.impl;

import com.berkayarslan.ProductEngage.Service.ProductService;
import com.berkayarslan.ProductEngage.controller.contract.ProductControllerContract;
import com.berkayarslan.ProductEngage.dto.ProductDTO;
import com.berkayarslan.ProductEngage.mapper.ProductMapper;
import com.berkayarslan.ProductEngage.model.Product;
import com.berkayarslan.ProductEngage.request.product.ProductBatchUpdateRequest;
import com.berkayarslan.ProductEngage.request.product.ProductSaveRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ProductControllerContractImpl implements ProductControllerContract {

    private final ProductService productService;

    public ProductControllerContractImpl(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public ProductDTO saveProduct(ProductSaveRequest request) {
        Product product = ProductMapper.INSTANCE.productDTOToProduct(request);
        product = productService.saveWithDefaultStatus(product);
        return ProductMapper.INSTANCE.productToProductDTO(product);
    }
    @Override
    public void saveAllProduct(List<ProductSaveRequest> request) {
        List<Product> productList = ProductMapper.INSTANCE.ProductDTOListToProductList(request);
        productList.forEach(product -> {
            productService.saveWithDefaultStatus(product);
        });
    }
    @Override
    public List<ProductDTO> findAllProducts() {
        return ProductMapper.INSTANCE.productListToProductDTOList(productService.findAll());
    }

    @Override
    public ProductDTO findProductById(Long id) {
        return ProductMapper.INSTANCE.productToProductDTO(productService.findByIdWithControl(id));
    }

    @Override
    public List<ProductDTO> findProductsByCategoryId(Long categoryId) {
        return ProductMapper.INSTANCE.productListToProductDTOList(productService.findByCategoryId(categoryId));
    }

    @Override
    public List<ProductDTO> findAllProductsByExpirationDateLE(LocalDateTime localDateTime) {
        return ProductMapper.INSTANCE.productListToProductDTOList(productService.findProductsByExpirationDateBefore(localDateTime));
    }

    @Override
    public ProductDTO updateProductPrice(Long id, Double price) {
        Product product = productService.updateProductPriceById(id,price);
        return ProductMapper.INSTANCE.productToProductDTO(product);
    }

    @Override
    public List<ProductDTO> batchUpdateProductPrice(List<ProductBatchUpdateRequest> request) {
        List<Product> updatedProducts = productService.batchUpdateProductPriceByList(request);
        return ProductMapper.INSTANCE.productListToProductDTOList(updatedProducts);
    }

    @Override
    public ProductDTO activateProduct(Long id) {
        Product product = productService.activateProduct(id);
        return ProductMapper.INSTANCE.productToProductDTO(product);
    }

    @Override
    public ProductDTO deactivateProduct(Long id) {
        Product product = productService.deactivateProduct(id);
        return ProductMapper.INSTANCE.productToProductDTO(product);
    }


}
