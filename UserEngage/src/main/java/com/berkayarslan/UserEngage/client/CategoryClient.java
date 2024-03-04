package com.berkayarslan.UserEngage.client;

import com.berkayarslan.UserEngage.dto.CategoryInfoDTO;
import com.berkayarslan.UserEngage.general.RestResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "category",url = "http://localhost:8080/api/v1/categorys")
public interface CategoryClient {

    @GetMapping("/{id}")
    ResponseEntity<RestResponse<CategoryInfoDTO>> getCategoryName(@PathVariable Long id);
}
