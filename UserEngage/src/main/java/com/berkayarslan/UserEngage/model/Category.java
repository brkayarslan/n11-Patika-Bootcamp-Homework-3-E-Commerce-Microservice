package com.berkayarslan.UserEngage.model;

import com.berkayarslan.UserEngage.general.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
@Table(name ="CATEGORY")
public class Category extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
}
