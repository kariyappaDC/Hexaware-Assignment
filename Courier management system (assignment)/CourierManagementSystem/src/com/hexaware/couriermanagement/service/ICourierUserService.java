package com.hexaware.couriermanagement.service;

import java.util.List;

import com.hexaware.couriermanagement.entity.Courier;
import com.hexaware.couriermanagement.exception.InvalidEmployeeIdException;
import com.hexaware.couriermanagement.exception.TrackingNumberNotFoundException;

public interface ICourierUserService {

	int placeOrder(Courier cr);
	String getOrderStatus(int trackingNumber)throws TrackingNumberNotFoundException;
	boolean cancelOrder(int trackingNumber)throws TrackingNumberNotFoundException;
	public List<Courier> getAssignedOrder(int employeeID) throws InvalidEmployeeIdException;
	
}
