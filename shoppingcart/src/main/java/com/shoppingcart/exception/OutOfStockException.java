package com.shoppingcart.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.INTERNAL_SERVER_ERROR, reason="Product out of stock")
public class OutOfStockException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	
	private String exceptionMessage;

    public OutOfStockException(final Exception e) {
        super(e);
    }

    public OutOfStockException(final String exceptionMessage) {
        super(exceptionMessage);
        this.exceptionMessage = exceptionMessage;
    }

    public OutOfStockException(final String exceptionMessage, final Exception e) {
        super(exceptionMessage, e);
        this.exceptionMessage = exceptionMessage;
    }
    
    public String getMessage() {
        return exceptionMessage;
    }
}
