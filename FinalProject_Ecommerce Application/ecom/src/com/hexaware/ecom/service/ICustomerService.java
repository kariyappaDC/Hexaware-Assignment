package com.hexaware.ecom.service;

/**
 * Author: Kariyappa D C, Eshwar Reddy V
 * Date: October 18, 2024
 * Description: This interface defines the methods for customer related operations 
 * in the e-commerce application, including adding customers, removing customers.
 *  It serves as the contract for the Cart Service implementation.
 */

import com.hexaware.ecom.entity.Customer;

public interface ICustomerService {

	boolean createCst(Customer cst);
	boolean removecst(Customer cst);
	
}
