package com.shoppingcart.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shoppingcart.models.ProductStock;

public interface IStockRepository extends JpaRepository<ProductStock, Integer> {
	
	ProductStock findByPId(Integer pid);

}
