package com.hexaware.ecom.service;


/**
 * Author: Kariyappa D C, Eshwar Reddy V
 * Date: October 18, 2024
 * Description: This interface defines the methods for order related operations 
 * in the e-commerce application, including adding order and order items 
 *  and retrieving all order items. It serves as the contract 
 * for the Oder Service implementation.
 */

import java.util.List;

import com.hexaware.ecom.entity.OrderItems;
import com.hexaware.ecom.entity.Orders;


public interface IOrderService {

    boolean addOrder(Orders order);

  
    boolean  addOrderItems(OrderItems orderItem);


    List<Orders> getAllOrders(int customerId);
    
    double calculateTotalPrice(Orders order, OrderItems orderItem);
	
}
