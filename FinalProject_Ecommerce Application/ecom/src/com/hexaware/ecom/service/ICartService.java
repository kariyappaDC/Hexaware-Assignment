package com.hexaware.ecom.service;

/**
 * Author: Kariyappa D C, Eshwar Reddy V
 * Date: October 18, 2024
 * Description: This interface defines the methods for cart-related operations 
 * in the e-commerce application, including adding items to the cart, removing 
 * items from the cart, and retrieving all cart items. It serves as the contract 
 * for the Cart Service implementation.
 */

import java.util.List;

import com.hexaware.ecom.entity.Cart;

public interface ICartService {

	
	boolean addCart(Cart car);
	boolean  removeCart(Cart car);
	List<Cart> getAllCart();
	
	
}
