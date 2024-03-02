package com.berkayarslan.UserEngage.service;

import com.berkayarslan.UserEngage.erroremessage.ProductErrorMessage;
import com.berkayarslan.UserEngage.erroremessage.UserCouponErrorMessage;
import com.berkayarslan.UserEngage.exceptions.ItemNotFoundException;
import com.berkayarslan.UserEngage.general.BaseEntityService;
import com.berkayarslan.UserEngage.model.Product;
import com.berkayarslan.UserEngage.model.Status;
import com.berkayarslan.UserEngage.repository.ProductRepository;
import com.berkayarslan.UserEngage.request.product.ProductBatchUpdateRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService extends BaseEntityService<Product, ProductRepository> {
    protected ProductService(ProductRepository repository) {
        super(repository);
    }


    public List<Product> findAll(){
        return getRepository().findAllByStatus(Status.ACTIVE);
    }

    public List<Product> findByCategoryId(Long categoryId) {

        List<Product> products = getRepository().findByStatusAndCategoryId(Status.ACTIVE,categoryId);
        if (products.isEmpty()){
            throw new ItemNotFoundException(ProductErrorMessage.PRODUCT_NOT_FOUND);
        }else {
            return products;
        }
    }

    public List<Product> findProductsByExpirationDateBefore (LocalDateTime localDateTime){
        return getRepository().findAllByStatusAndExpirationDateBefore(Status.ACTIVE,localDateTime);
    }

    public Product saveWithDefaultStatus(Product product) {
        product.setStatus(Status.INACTIVE);
        return save(product);
    }

    public Product updateProductPriceById(Long id, Double price){
        Product product= super.findByIdWithControl(id);
        product.setPrice(price);
        return save(product);
    }

    @Transactional
    public List<Product> batchUpdateProductPriceByList(List<ProductBatchUpdateRequest> request){

        List<Product> productList = new ArrayList<>();

        request.forEach(updateRequest ->{
            super.findById(updateRequest.id()).ifPresent(product -> {
                product.setPrice(updateRequest.price());
                productList.add(save(product));
            });
        });

        return productList;
    }

    public Product activateProduct(Long id){
        Product product = super.findByIdWithControl(id);
        product.setStatus(Status.ACTIVE);
        return save(product);
    }

    public Product deactivateProduct(Long id){
        Product product = super.findByIdWithControl(id);
        product.setStatus(Status.INACTIVE);
        return save(product);
    }
}
