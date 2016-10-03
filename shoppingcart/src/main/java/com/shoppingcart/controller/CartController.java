package com.shoppingcart.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.shoppingcart.exception.OutOfStockException;
import com.shoppingcart.models.Product;
import com.shoppingcart.service.IBuyService;
import com.shoppingcart.view.ResponseView;

@RestController
@RequestMapping("/cart")
public class CartController {
	
	private IBuyService buyService;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseView getCart() {
		return new ResponseView();
	}
	
	@RequestMapping(method=RequestMethod.PUT)
	public ResponseView modifyCart(Product p,Integer count) throws OutOfStockException{
		buyService.addToCart(p, count);
		return new ResponseView();
	}
	
	@RequestMapping(method=RequestMethod.DELETE)
	public ResponseView clearCart(){
		return new ResponseView();
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseView buyProductsCart(){
		buyService.buyCartProducts();
		return new ResponseView();
	}

}
