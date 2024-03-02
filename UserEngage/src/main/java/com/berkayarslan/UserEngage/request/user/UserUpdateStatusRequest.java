package com.berkayarslan.UserEngage.request.user;

import com.berkayarslan.UserEngage.model.Status;

public record UserUpdateStatusRequest(Long id, Status status) {
}
