package com.hexaware.ecom.service;

/**
 * Author: Kariyappa D C, Eshwar Reddy V
 * Date: October 17, 2024
 * Description: This class implements the Order  Service layer for the e-commerce 
 * application. It handles operations related to adding and validating
 * Orders and Order Item by interacting with the Order DAO layer. 
 */

import java.util.List;


import com.hexaware.ecom.dao.IOrderDao;
import com.hexaware.ecom.dao.OrderDaoImp;
import com.hexaware.ecom.entity.OrderItems;
import com.hexaware.ecom.entity.Orders;
import com.hexaware.ecom.exceptions.CustomerNotFoundException;


public class OrderServiceImp implements IOrderService {

	
    private IOrderDao orderDao;
    
	public OrderServiceImp() {
		
		orderDao = new OrderDaoImp();	
	}

	
	public  double calculateTotalPrice(Orders order, OrderItems orderItem) {
	    double totalPrice = 0.0;

	    
	    double productPrice = orderDao.getProductPrice(orderItem.getProductId());


	   
	    totalPrice = productPrice * orderItem.getQuantity();

	    
	    order.setTotalPrice(totalPrice);

	    return totalPrice;
	}


	@Override
	public boolean addOrder(Orders order) {
		
		return orderDao.addOrder(order);
	}
	

	@Override
	public boolean addOrderItems(OrderItems orderItem) {
		
		return orderDao.addOrderItems(orderItem);
	}

	
	
 
	

	
	public static  boolean validateOrder(OrderItems ordItm) {
		
		boolean flag = false;
		if(ordItm.getQuantity()>0) {
			flag = true;
		}
		return flag;
	}


	@Override
public List<Orders> getAllOrders(int customerId) {

	    List<Orders> ordersList = orderDao.getAllOrders(customerId); 

	    if (ordersList == null || ordersList.isEmpty()) {
	        throw new CustomerNotFoundException("Customer with ID=" + customerId + " not found.");
	    }
	    return ordersList;
	}

	
	
}
