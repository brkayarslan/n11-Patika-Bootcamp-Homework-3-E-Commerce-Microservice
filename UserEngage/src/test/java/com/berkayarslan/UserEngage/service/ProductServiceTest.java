package com.berkayarslan.UserEngage.service;

import com.berkayarslan.UserEngage.exceptions.ItemNotFoundException;
import com.berkayarslan.UserEngage.model.Product;
import com.berkayarslan.UserEngage.model.Status;
import com.berkayarslan.UserEngage.model.UserCoupon;
import com.berkayarslan.UserEngage.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {

    @Mock
    ProductRepository productRepository;

    @InjectMocks
    ProductService productService;

    @Test
    void findByCategoryId_WithExistingProduct() {
        Long categoryId = 1L;

        Product product1 = new Product();
        product1.setStatus(Status.ACTIVE);
        product1.setCategoryId(1L);
        Product product2 = new Product();
        product2.setStatus(Status.ACTIVE);
        product2.setCategoryId(1L);

        List<Product> expextedProducts = new ArrayList<>();
        expextedProducts.add(product1);
        expextedProducts.add(product2);

        when(productRepository.findByStatusAndCategoryId(Status.ACTIVE,categoryId)).thenReturn(expextedProducts);

        List<Product> actualProducts = productService.findByCategoryId(categoryId);

        assertFalse(actualProducts.isEmpty());
        assertEquals(expextedProducts,actualProducts);
    }

    @Test
    void findByCategoryId_WithNoProduct(){
        Long categoryId = 1L;

        when(productRepository.findByStatusAndCategoryId(Status.ACTIVE,categoryId)).thenReturn(new ArrayList<>());

        assertThrows(ItemNotFoundException.class,() -> productService.findByCategoryId(categoryId));

    }
}