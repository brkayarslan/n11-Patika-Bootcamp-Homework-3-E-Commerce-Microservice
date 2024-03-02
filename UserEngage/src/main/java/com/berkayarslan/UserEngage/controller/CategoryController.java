package com.berkayarslan.UserEngage.controller;


import com.berkayarslan.UserEngage.controller.contract.CategoryControllerContract;
import com.berkayarslan.UserEngage.dto.CategoryDTO;
import com.berkayarslan.UserEngage.general.RestResponse;
import com.berkayarslan.UserEngage.request.category.CategorySaveRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/categorys")
public class CategoryController {

    private CategoryControllerContract categoryControllerContract;


    public CategoryController(CategoryControllerContract categoryControllerContract) {
        this.categoryControllerContract = categoryControllerContract;
    }

    @GetMapping
    public ResponseEntity<RestResponse<List<CategoryDTO>>> findAllCategory(){
        return ResponseEntity.ok(RestResponse.of(categoryControllerContract.findAllCategory()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<RestResponse<CategoryDTO>> findByIdCategory(@PathVariable Long id){
        return ResponseEntity.ok(RestResponse.of(categoryControllerContract.findByCategoryId(id)));
    }

    @PostMapping
    public ResponseEntity<RestResponse<CategoryDTO>> saveCategory(@RequestBody CategorySaveRequest request){
        return ResponseEntity.ok(RestResponse.of(categoryControllerContract.saveCategory(request)));
    }

    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable Long id){
        categoryControllerContract.deleteByCategoryId(id);
    }

}
