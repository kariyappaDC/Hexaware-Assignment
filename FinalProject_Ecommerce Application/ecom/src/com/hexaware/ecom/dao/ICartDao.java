package com.hexaware.ecom.dao;

/**
 * Author: Kariyappa D C ,  Eshwar Reddy V
 * Date: October 18, 2024
 * Description: This interface defines the methods for managing Cart operations 
 * in the e-commerce system. It includes methods for adding a cart, removing a cart, 
 * and retrieving all cart items from the database.
 */

import com.hexaware.ecom.entity.Cart;

import java.util.List;

public interface ICartDao {
	
	boolean addCart(Cart car);
	boolean removeCart(Cart car);
	List<Cart> getAllCart();
	

}
