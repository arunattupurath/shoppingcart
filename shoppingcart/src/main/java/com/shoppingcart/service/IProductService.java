package com.shoppingcart.service;

import java.util.List;
import com.shoppingcart.models.Product;

public interface IProductService {
	
	public Integer getProductStock(Integer pId);
	
	public Boolean setProductStock(Integer productid,Integer count);
	
	public Product getProduct(Integer productId);
	
	public List<Product> getproductList();
	
}
