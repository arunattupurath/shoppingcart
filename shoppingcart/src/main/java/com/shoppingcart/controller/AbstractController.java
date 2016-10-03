package com.shoppingcart.controller;

import org.springframework.beans.factory.annotation.Autowired;

import com.shoppingcart.locale.ILocaleService;

public class AbstractController {
	
	@Autowired
	private ILocaleService localeMessageService;
	
	protected String getMessage(String keyWord){
		return localeMessageService.getMessage(keyWord);
	}

}
