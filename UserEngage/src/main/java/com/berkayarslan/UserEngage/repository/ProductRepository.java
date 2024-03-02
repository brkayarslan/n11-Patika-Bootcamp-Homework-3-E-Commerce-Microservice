package com.berkayarslan.UserEngage.repository;

import com.berkayarslan.UserEngage.model.Product;
import com.berkayarslan.UserEngage.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Long> {

    List<Product> findAllByStatus(Status status);

    List<Product> findAllByStatusAndId(Status status, Long id);
    List<Product> findAllByStatusAndExpirationDateBefore(Status status, LocalDateTime localDateTime);

    List<Product> findByStatusAndCategoryId(Status status,Long categoryId);


}
