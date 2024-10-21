package com.hexaware.ecom.dao;

/**
 * Author: Kariyappa D C ,  Eshwar Reddy V
 * Date: October 18, 2024
 * Description: This interface defines the methods for managing Cart operations 
 * in the e-commerce system. It includes methods for creating the product and removing the product  from the database.
 */

import com.hexaware.ecom.entity.Product;

public interface IProductDao {

	boolean createPrd(Product prd);
	boolean removePrd(Product prd);
	
}
