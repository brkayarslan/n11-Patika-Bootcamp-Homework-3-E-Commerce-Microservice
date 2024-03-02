package com.berkayarslan.UserEngage.repository;

import com.berkayarslan.UserEngage.model.User;
import com.berkayarslan.UserEngage.model.UserCoupon;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Long> {

}
