package com.berkayarslan.UserEngage.client;


import com.berkayarslan.UserEngage.dto.CategoryInfoDTO;
import com.berkayarslan.UserEngage.dto.ProductInfoDTO;
import com.berkayarslan.UserEngage.general.RestResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "test",url = "http://localhost:8080/api/v1/products")
public interface ProductClient {

    @GetMapping("/{id}")
    ResponseEntity<RestResponse<ProductInfoDTO>> getProduct(@PathVariable Long id);
}
