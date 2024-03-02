package com.berkayarslan.UserEngage.request.user;

import com.berkayarslan.UserEngage.model.Gender;
import com.berkayarslan.UserEngage.model.Status;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record UserSaveRequest (String name,
                               String surname,
                               LocalDate birthDate,
                               String email,
                               Gender gender,
                               Status status
                               ){

}
