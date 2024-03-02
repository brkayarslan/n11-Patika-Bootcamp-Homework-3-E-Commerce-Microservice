package com.berkayarslan.UserEngage.exceptions;

import com.berkayarslan.UserEngage.general.BaseErrorMessage;
import com.berkayarslan.UserEngage.general.BusinessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ItemNotFoundException extends BusinessException {

    public ItemNotFoundException(BaseErrorMessage baseErrorMessage) {
        super(baseErrorMessage);
    }
}
