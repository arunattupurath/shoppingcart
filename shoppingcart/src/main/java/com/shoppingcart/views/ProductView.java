package com.shoppingcart.views;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.shoppingcart.models.Product;
import com.shoppingcart.view.IShoppingCartView;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductView implements IShoppingCartView {
 
	private static final long serialVersionUID = 1L;
	
	private List<Product> pList;
	
	private Product p;
	
	public Product getP() {
		return p;
	}

	public void setP(Product p) {
		this.p = p;
	}

	public ProductView(List<Product> pList){
		this.pList = pList;
	}
	
	public ProductView(Product p){
		this.p = p;
	}
	
	public List<Product> getpList() {
		return pList;
	}

	public void setpList(List<Product> pList) {
		this.pList = pList;
	}
    
}
