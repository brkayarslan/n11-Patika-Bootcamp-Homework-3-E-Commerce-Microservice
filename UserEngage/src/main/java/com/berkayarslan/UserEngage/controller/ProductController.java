package com.berkayarslan.UserEngage.controller;

import com.berkayarslan.UserEngage.controller.contract.ProductControllerContract;
import com.berkayarslan.UserEngage.dto.ProductDTO;
import com.berkayarslan.UserEngage.general.RestResponse;
import com.berkayarslan.UserEngage.request.product.ProductBatchUpdateRequest;
import com.berkayarslan.UserEngage.request.product.ProductSaveRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    private ProductControllerContract productControllerContract;


    public ProductController(ProductControllerContract productControllerContract) {
        this.productControllerContract = productControllerContract;
    }

    @GetMapping
    public ResponseEntity<RestResponse<List<ProductDTO>>> findAllProducts(){
        return ResponseEntity.ok(RestResponse.of(productControllerContract.findAllProducts()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<RestResponse<ProductDTO>> findProductById(@PathVariable Long id){
        return ResponseEntity.ok(RestResponse.of(productControllerContract.findProductById(id)));
    }

    @GetMapping("/categoryId/{id}")
    public ResponseEntity<RestResponse<List<ProductDTO>>> findProductsByCategoryId(@PathVariable Long id){
        return ResponseEntity.ok(RestResponse.of(productControllerContract.findProductsByCategoryId(id)));
    }

    @GetMapping("/expirationDate")
    public ResponseEntity<RestResponse<List<ProductDTO>>> findAllProductsByExpirationDateLE(@RequestParam LocalDateTime localDateTime){
        return ResponseEntity.ok(RestResponse.of(productControllerContract.findAllProductsByExpirationDateLE(localDateTime)));
    }

    @PostMapping
    public ResponseEntity<RestResponse<ProductDTO>> saveProduct(@RequestBody ProductSaveRequest request){
        return ResponseEntity.ok(RestResponse.of(productControllerContract.saveProduct(request)));
    }

    @PostMapping("/all")
    public void saveAllProducts(@RequestBody List<ProductSaveRequest> request){
        productControllerContract.saveAllProduct(request);
    }

    @PatchMapping("/{id}/price")
    public ResponseEntity<RestResponse<ProductDTO>> updateProductPrice(@RequestParam Long id, @RequestParam Double price){
        return ResponseEntity.ok(RestResponse.of(productControllerContract.updateProductPrice(id, price)));
    }

    @PutMapping
    public ResponseEntity<RestResponse<List<ProductDTO>>> batchUpdateProductPrice(@RequestBody List<ProductBatchUpdateRequest> request){
        List<ProductDTO> productDTO = productControllerContract.batchUpdateProductPrice(request);
        return ResponseEntity.ok(RestResponse.of(productDTO));
    }

    @PatchMapping("/{id}/activate")
    public ResponseEntity<RestResponse<ProductDTO>> activateProduct(@PathVariable Long id){
        return ResponseEntity.ok(RestResponse.of(productControllerContract.activateProduct(id)));
    }

    @PatchMapping("/{id}/deactivate")
    public ResponseEntity<RestResponse<ProductDTO>> deactivateProduct(@PathVariable Long id){
        return ResponseEntity.ok(RestResponse.of(productControllerContract.deactivateProduct(id)));
    }
}
