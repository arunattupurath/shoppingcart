package com.shoppingcart.view;

import java.io.Serializable;
import java.util.List;

public class ResponseView implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private IShoppingCartView data;
	
	private String message;
	
	private Boolean status;

	public IShoppingCartView getData() {
		return data;
	}

	public void setData(IShoppingCartView data) {
		this.data = data;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

}
