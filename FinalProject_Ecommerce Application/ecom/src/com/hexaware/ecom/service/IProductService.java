package com.hexaware.ecom.service;

/**
 * Author: Kariyappa D C, Eshwar Reddy V
 * Date: October 18, 2024
 * Description: This interface defines the methods for product related operations 
 * in the e-commerce application, including creating products and removing the product
 * It serves as the contract for the Cart Service implementation.
 */

import com.hexaware.ecom.entity.Product;

public interface IProductService {

	boolean createPrd(Product prd);
	boolean removePrd(Product prd);
	
}
