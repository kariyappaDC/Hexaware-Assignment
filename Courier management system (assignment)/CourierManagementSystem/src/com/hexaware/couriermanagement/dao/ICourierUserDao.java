package com.hexaware.couriermanagement.dao;

import java.util.List;

import com.hexaware.couriermanagement.entity.Courier;

public interface ICourierUserDao {

	int placeOrder(Courier cr);
	String getOrderStatus(int trackingNumber);
	boolean cancelOrder(int trackingNumber);
	public List<Courier> getAssignedOrder(int employeeID);
	
}
