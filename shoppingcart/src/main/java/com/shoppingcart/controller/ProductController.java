package com.shoppingcart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.shoppingcart.constants.MessageConstants;
import com.shoppingcart.models.Product;
import com.shoppingcart.service.IProductService;
import com.shoppingcart.view.ResponseView;
import com.shoppingcart.views.ProductView;

@RestController
@RequestMapping("/products")
public class ProductController extends AbstractController {
	
	@Autowired
	IProductService productService;

	@RequestMapping(method=RequestMethod.GET)
	public ResponseView getproducts(){
		
		ResponseView rv = new ResponseView();
		rv.setData(new ProductView(productService.getproductList()));
		rv.setMessage(getMessage(MessageConstants.PRODUCT_LIST_SUCESS));
		rv.setStatus(true);
		return rv;
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/{productId}")
	public ResponseView getproduct(@PathVariable Integer productId){
		ResponseView rv = new ResponseView();
		rv.setData(new ProductView(productService.getProduct(productId)));
		rv.setMessage(getMessage(MessageConstants.PRODUCT_LIST_SUCESS));
		rv.setStatus(true);
		return rv;
	}
	
	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(method=RequestMethod.POST)
	public ResponseView addproduct(@RequestBody Product p){
		return new ResponseView();
	}
	
	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(method=RequestMethod.PUT)
	public ResponseView updateproduct(@RequestBody Product p){
		return new ResponseView();
	}
	
	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(method=RequestMethod.DELETE,value="/{productId}")
	public ResponseView removeproduct(){
		return new ResponseView();
	}
	
}
