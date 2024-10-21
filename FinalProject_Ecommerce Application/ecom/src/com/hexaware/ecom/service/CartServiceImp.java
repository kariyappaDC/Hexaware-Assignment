package com.hexaware.ecom.service;

/**
 * Author: Kariyappa D C, Eshwar Reddy V
 * Date: October 17, 2024
 * Description: This class implements the Cart Service layer for the e-commerce 
 * application. It handles operations related to adding, removing, and validating
 * cart items by interacting with the Cart DAO layer. The service also throws 
 * exceptions when certain conditions, such as a non-existent customer, are met.
 */

import java.util.List;

import com.hexaware.ecom.dao.CartDaoImp;
import com.hexaware.ecom.dao.ICartDao;
import com.hexaware.ecom.entity.Cart;
import com.hexaware.ecom.exceptions.CustomerNotFoundException;

public class CartServiceImp implements ICartService{

	
	private ICartDao dao;
	
	public CartServiceImp() {
		
		dao = new CartDaoImp();	
	}
	
	@Override
	public boolean addCart(Cart car) {
		 
		boolean cartadd= dao.addCart(car);
			if(!cartadd) {
					throw new CustomerNotFoundException("customer not found ");
				
			}
			return cartadd;
				
			}
	
	@Override
	public boolean removeCart(Cart car) {
		return dao.removeCart(car);
	}

	@Override
	public List<Cart> getAllCart() {
		
		return dao.getAllCart();
	}

	
	public static  boolean validateCart(Cart car) {
		
		boolean flag = false;
	    if (car.getQuantity() >  0) {
	      
	        flag = true;
	}else {
		 System.out.println("Invalid quantity: " + car.getQuantity() + ". Quantity should be greater than 0.");
	}
	    return flag; 
	}

	

	
}
