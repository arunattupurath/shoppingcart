package com.shoppingcart.models;

public class ProductCartDetails {

	private Product product;

	private Integer Count;

	private Double cost;

	private Double totalCost;
	
	public ProductCartDetails(Product product){
		this.product = product;
	}

	public Product getProduct() {
		return product;
	}

	public void setProductCount(Integer Count) {
		this.Count = Count;
		this.cost = Count*product.getCost();
		this.totalCost = this.cost*product.getType().getSalesTax();
	}

	public Integer getCount() {
		return Count;
	}

	
}
