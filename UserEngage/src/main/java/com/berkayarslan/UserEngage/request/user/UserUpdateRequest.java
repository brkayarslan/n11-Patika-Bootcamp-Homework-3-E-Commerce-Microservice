package com.berkayarslan.UserEngage.request.user;

import com.berkayarslan.UserEngage.model.Gender;

import java.time.LocalDate;

public record UserUpdateRequest (
        Long id,
        String name,
        String surname,
        LocalDate birthDate,
        String email){
}
