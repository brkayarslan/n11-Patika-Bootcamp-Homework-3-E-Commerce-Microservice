package com.berkayarslan.UserEngage.dto;

import com.berkayarslan.UserEngage.model.Gender;
import com.berkayarslan.UserEngage.model.Status;

import java.time.LocalDate;
import java.time.LocalDateTime;


public record UserDTO (
        Long id,
        String name,
        String surname,
        LocalDateTime createDate,
        LocalDate birthDate,
        String email,
        Gender gender,
        Status status){





}
