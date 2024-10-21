package com.hexaware.ecom.dao;

/**
 * Author: Kariyappa D C ,  Eshwar Reddy V
 * Date: October 18, 2024
 * Description: This interface defines the methods for managing Cart operations 
 * in the e-commerce system. It includes methods for adding order and order items and display all orders items from the database.
 */

import java.util.List;
import com.hexaware.ecom.entity.OrderItems;
import com.hexaware.ecom.entity.Orders;

public interface IOrderDao {
	
    boolean addOrder(Orders order);

    
    boolean  addOrderItems(OrderItems orderItem);
	
    
    List<Orders> getAllOrders(int customerId);
    
    double getProductPrice(int productId);
   
}
