package com.shoppingcart;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

import com.shoppingcart.config.security.CustomAuthenticationProvider;
import com.shoppingcart.controller.ProductController;
import com.shoppingcart.models.Product;
import com.shoppingcart.repository.IProductRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ShoppingcartApplicationTests {

	@Autowired
	private CustomAuthenticationProvider provider;

    @Autowired
	private IProductRepository proRepo;	
	
	@Before
	public void setUp() throws Exception {

		Authentication auth;

		UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(
				"johndoe@demo.com", "India_1234");

		auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth == null) {
			auth = provider.authenticate(authRequest);
			SecurityContextHolder.getContext().setAuthentication(auth);
		}
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		SecurityContextHolder.clearContext();
	}

	@Test
	public void testProd(){
		Product p =proRepo.findOne(1);
		Assert.notNull(p);
	}
	
}
