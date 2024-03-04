package com.berkayarslan.UserEngage.request.user;

import com.berkayarslan.UserEngage.model.Gender;
import com.berkayarslan.UserEngage.model.Status;

import java.time.LocalDate;

public record UserSaveRequest (String name,
                               String surname,
                               LocalDate birthDate,
                               String email,
                               Gender gender,
                               Status status
                               ){

}
