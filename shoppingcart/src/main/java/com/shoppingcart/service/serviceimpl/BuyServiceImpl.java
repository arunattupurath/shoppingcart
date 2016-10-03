package com.shoppingcart.service.serviceimpl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.shoppingcart.exception.OutOfStockException;
import com.shoppingcart.models.Cart;
import com.shoppingcart.models.Product;
import com.shoppingcart.models.ProductCartDetails;
import com.shoppingcart.service.IBuyService;
import com.shoppingcart.service.IProductService;

public class BuyServiceImpl implements IBuyService{
	
	@Autowired // This is a session scoped bean
	private Cart cart;
	
	private IProductService productService;

	@Override
	public Cart checkOut() {
		return cart;
	}

	@Override
	public Boolean buyCartProducts() throws OutOfStockException {
		Map<Integer, ProductCartDetails> prodCardDetailsList = cart.getProdCardDetails();
		prodCardDetailsList.forEach((k,v)->{
			if(productService.getProductStock(k) < v.getCount())
				throw new OutOfStockException(v.getProduct().getName()+" does not have "+v.getCount()+ "in stock");
			productService.setProductStock(k,productService.getProductStock(k)-v.getCount());
		});
		cart.setStatusBought(true);
		return cart.clear();
	}

	@Override
	public Boolean addToCart(Product p, Integer count) throws OutOfStockException {
		
		if(productService.getProductStock(p.getId()) < count)
			throw new OutOfStockException("");
		
		Map<Integer, ProductCartDetails> prodCardDetailsList = cart.getProdCardDetails();
		try{
			ProductCartDetails pcd;
			Integer key = p.getId();
			if(prodCardDetailsList.containsKey(key))
				pcd = prodCardDetailsList.get(key);
			else
				pcd = new ProductCartDetails(p);
			pcd.setProductCount(count);
			prodCardDetailsList.put(key, pcd);
			cart.setProdCardDetails(prodCardDetailsList);
			return true;
		}
		catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Boolean clearCart() {
		cart.setProdCardDetails(new HashMap<Integer, ProductCartDetails>());
		cart.setStatusBought(false);
		cart.setTotalCost(0.0);
		return null;
	}
	
}
