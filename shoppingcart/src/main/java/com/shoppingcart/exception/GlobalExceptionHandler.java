package com.shoppingcart.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shoppingcart.view.ResponseView;

@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {

	final static Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);
	
	@ExceptionHandler(value = OutOfStockException.class)
	public ResponseView outOfStockException(OutOfStockException e) {
		logger.debug("Business Exception",e);
		ResponseView responseView = new ResponseView();
		if(e.getMessage() == null)
			responseView.setMessage(e.getCause().getMessage());
		else
			responseView.setMessage(e.getMessage());
		responseView.setStatus(false);
		return responseView;

	}

	@ExceptionHandler(value = Exception.class)
	public ResponseView genericException(Exception e) {
		logger.debug("genericException",e);
		ResponseView responseView = new ResponseView();
		responseView.setMessage(e.getMessage());
		responseView.setStatus(false);
		return responseView;
	}
	
}
