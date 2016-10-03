package com.shoppingcart.service.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shoppingcart.models.Product;
import com.shoppingcart.models.ProductStock;
import com.shoppingcart.repository.IProductRepository;
import com.shoppingcart.repository.IStockRepository;
import com.shoppingcart.service.IProductService;

@Service
public class ProductServiceImpl implements IProductService {
	
	@Autowired
	private IStockRepository stockRepository;
	
	@Autowired
	private IProductRepository productRepository;

	public Integer getProductStock(Integer pId){
		return stockRepository.findByPId(pId).getProductCount();
	}
	
	public Boolean setProductStock(Integer pId,Integer count){
		ProductStock ps = stockRepository.findByPId(pId);
		ps.setProductCount(count);
		stockRepository.save(ps);
		return true;
	}

	@Override
	public Product getProduct(Integer productId) {
		return productRepository.findOne(productId);
	}

	@Override
	public List<Product> getproductList() {
		return productRepository.findAll();
	}

	
	
}
