package com.shoppingcart.service;

import com.shoppingcart.exception.OutOfStockException;
import com.shoppingcart.models.Cart;
import com.shoppingcart.models.Product;

public interface IBuyService {

	Boolean addToCart(Product p,Integer count)  throws OutOfStockException ;
	
	Cart checkOut();
	
	Boolean buyCartProducts()  throws OutOfStockException ;
	
	Boolean clearCart();
}
