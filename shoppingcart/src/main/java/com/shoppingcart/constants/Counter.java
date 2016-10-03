package com.shoppingcart.constants;

public enum Counter {
	
	DECREMENT(1),INCREMENT(2);
	
	private int value;
	
	Counter(int x){
		this.value = x;
	}
	
	public int getx(){
		return this.value;
	}

}
