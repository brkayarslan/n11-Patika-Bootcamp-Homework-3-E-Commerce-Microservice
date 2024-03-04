package com.berkayarslan.UserEngage.dto;


import com.berkayarslan.UserEngage.model.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductInfoDTO {

    private Long id;
    private String name;
    private double price;
    private LocalDateTime expirationDate;
    private String description;
    private int categoryId;
    private Status status;
}
