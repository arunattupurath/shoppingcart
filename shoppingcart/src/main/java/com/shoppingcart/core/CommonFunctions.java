package com.shoppingcart.core;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.StringUtils;

import com.shoppingcart.models.User;

public class CommonFunctions {
	
	public static String getUserLang(){
		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String lang = StringUtils.hasText(user.getlang()) ? user.getlang() : "en";
		return lang;
	}

}
