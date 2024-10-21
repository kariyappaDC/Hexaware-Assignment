package com.hexaware.ecom.service;


/**
 * Author: Kariyappa D C, Eshwar Reddy V
 * Date: October 17, 2024
 * Description: This class implements the Customer Service layer for the e-commerce 
 * application. It handles operations related to adding, removing, and validating
 * customers by interacting with the Customer DAO layer. The service also throws 
 * exceptions when certain conditions, such as a non-existent customer, are met.
 */

import com.hexaware.ecom.dao.CustomerDaoImp;
import com.hexaware.ecom.dao.ICustomerDao;
import com.hexaware.ecom.entity.Customer;

public class CustomerServiceImp implements ICustomerService {
	

	private	ICustomerDao dao;
	public CustomerServiceImp() {
		dao=new CustomerDaoImp();
	}
	
	
	@Override
	public boolean createCst(Customer cst) {
		
		return dao.createCst(cst);
	}
	
	@Override
	public boolean removecst(Customer cst) {
		
		return dao.removeCst(cst);
	}



	
	
	public static boolean vaildateCst(Customer cst) {
		
		
		boolean flag=false;
		String emailval= "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
		if(cst.getCustomerId()>100 && cst.getName().length()>3 && cst.getEmail().matches(emailval) && cst.getPassword().length()>=5) {
			
			flag=true;
		}
		return flag;
	}

}
