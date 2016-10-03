package com.shoppingcart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shoppingcart.constants.MessageConstants;
import com.shoppingcart.locale.ILocaleService;


@Controller
public class WebController extends AbstractController{

	@Autowired
	private ILocaleService localeMessageService;
	
	@RequestMapping("/login")
	public String getLoginPage(){
		return "login";
	}
	
	@RequestMapping("/productlist")
	public String getProductListPage(ModelMap model){
		model.addAttribute("message", getMessage(MessageConstants.PRODUCT_LIST_SUCESS));
		return "productlist";
	}
	
	@RequestMapping("/admin")
	public String getAdminPage(ModelMap model){
		model.addAttribute("message", localeMessageService.getMessage(MessageConstants.adminmessage));
		return "admin";
	}
}
