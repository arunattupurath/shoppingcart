package com.shoppingcart.models;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;

@Scope(scopeName="session",proxyMode=ScopedProxyMode.TARGET_CLASS)
public class Cart {

	private Map<Integer, ProductCartDetails> prodCardDetails = new HashMap<Integer, ProductCartDetails>();

	private Double totalCost;
	
	private Boolean statusBought = false;

	public Map<Integer, ProductCartDetails> getProdCardDetails() {
		return prodCardDetails;
	}

	public void setProdCardDetails(Map<Integer, ProductCartDetails> prodCardDetails) {
		this.prodCardDetails = prodCardDetails;
	}

	public Double getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(Double totalCost) {
		this.totalCost = totalCost;
	}
	
	public Boolean getStatusBought() {
		return statusBought;
	}

	public void setStatusBought(Boolean statusBought) {
		this.statusBought = statusBought;
	}
	
	
	public Boolean clear(){
		this.statusBought = false;
		this.prodCardDetails = new HashMap<Integer, ProductCartDetails>();
		this.totalCost = 0.0;
		return true;
	}
}
