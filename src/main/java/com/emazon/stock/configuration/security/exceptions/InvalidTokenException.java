package com.emazon.stock.configuration.security.exceptions;

import com.emazon.stock.domain.utils.DomainConstants;
import org.springframework.security.core.AuthenticationException;

public class InvalidTokenException extends AuthenticationException {
    public InvalidTokenException() {
        super(DomainConstants.INVALID_TOKEN_MESSAGE);
    }
}
