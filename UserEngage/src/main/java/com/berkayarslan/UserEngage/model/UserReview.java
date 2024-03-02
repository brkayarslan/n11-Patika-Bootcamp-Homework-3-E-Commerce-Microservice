package com.berkayarslan.UserEngage.model;


import com.berkayarslan.UserEngage.general.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "userReview")
public class UserReview extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.PRIVATE)
    private Long id;


    @Column(nullable = false)
    private Long userId;

    @Column(nullable = false)
    private Integer productId;

    @Column(nullable = false)
    private Integer orderId;

    @Enumerated(EnumType.STRING)
    private Rate rate;

    private String comment;
}
