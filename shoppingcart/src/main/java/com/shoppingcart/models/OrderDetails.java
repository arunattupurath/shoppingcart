package com.shoppingcart.models;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="ORDER_DETAILS")
public class OrderDetails {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	@OneToOne
	@JoinColumn(name="PRODUCT_ID")
	private Product p;
	
	@Column(name="QUANTITY")
	private Integer productCount;
	
	@Transient
	private Map<Integer,Product> productStatus = new HashMap<Integer,Product>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public Product getP() {
		return p;
	}

	public void setP(Product p) {
		this.p = p;
	}

	public Integer getProductCount() {
		return productCount;
	}

	public void setProductCount(Integer productCount) {
		this.productCount = productCount;
	}

	public Map<Integer, Product> getProductStatus() {
		return productStatus;
	}

	public void setProductStatus(Map<Integer, Product> productStatus) {
		this.productStatus = productStatus;
	}

}
