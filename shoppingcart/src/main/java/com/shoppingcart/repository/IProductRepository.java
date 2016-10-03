package com.shoppingcart.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shoppingcart.models.Product;

public interface IProductRepository extends JpaRepository<Product, Integer>{

}
