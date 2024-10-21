package com.hexaware.ecom.dao;

/**
 * Author: Kariyappa D C , Eshwar Reddy V
 * Date: October 18, 2024
 * Description: This interface defines the methods for managing Cart operations 
 * in the e-commerce system. It includes methods for creating the customer 
 * and removing the customer  from the database.
 */

import com.hexaware.ecom.entity.Customer;

public interface ICustomerDao {
	
	boolean createCst(Customer cst);
	boolean removeCst(Customer cst);
	

}
