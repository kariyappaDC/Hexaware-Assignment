package com.hexaware.ecom.service;

/**
 * Author: Kariyappa D C, Eshwar Reddy V
 * Date: October 17, 2024
 * Description: This class implements the Product Service layer for the e-commerce 
 * application. It handles operations related to adding, removing, and validating
 * Product by interacting with the Product DAO layer. The service also throws 
 * exceptions when certain conditions, such as a non-existent Product, are met.
 */

import com.hexaware.ecom.dao.IProductDao;
import com.hexaware.ecom.dao.ProductDaoImp;
import com.hexaware.ecom.entity.Product;
import com.hexaware.ecom.exceptions.ProductNotFoundException;

public class ProductServiceImp implements IProductService {

	private	IProductDao dao;
	
	public ProductServiceImp() {
		dao=new ProductDaoImp();
	}
	
	@Override
	public boolean createPrd(Product prd) {
		
		return dao.createPrd(prd);
	}
	
	@Override
	public boolean removePrd(Product prd) {
		
		boolean prdrm = dao.removePrd(prd);
		if(!prdrm) {
			try {
				throw new ProductNotFoundException("product not found");
			}
			catch(Exception e) {
				System.err.println("Product not found ID="+ prd.getProductId());
			}
			
		}
		return prdrm;
			
		}

	
	public static boolean vaildatePrd(Product prd) {
		
		
		boolean flag=false;
		if(prd.getProductId()>200 && prd.getName().length()>2 && prd.getPrice()>0 && prd.getStockQuantity()>0) {
			
			flag=true;
		}
		return flag;
	}
	
}
