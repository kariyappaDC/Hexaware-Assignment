package com.hexaware.couriermanagement.service;

import java.util.List;

import com.hexaware.couriermanagement.dao.CourierUserDaoImp;
import com.hexaware.couriermanagement.dao.ICourierUserDao;
import com.hexaware.couriermanagement.entity.Courier;
import com.hexaware.couriermanagement.exception.TrackingNumberNotFoundException;
import com.hexaware.couriermanagement.exception.InvalidEmployeeIdException;

public class CourierUserServiceImp implements ICourierUserService {

    private ICourierUserDao dao;

    public CourierUserServiceImp() {
        dao = new CourierUserDaoImp();
    }

    @Override
    public int placeOrder(Courier cr) {
        return dao.placeOrder(cr);
    }

    @Override
    public String getOrderStatus(int trackingNumber) throws TrackingNumberNotFoundException {
        String status = dao.getOrderStatus(trackingNumber);
        if (status == null) {
            throw new TrackingNumberNotFoundException("Tracking number " + trackingNumber + " not found in the system.");
        }
        return status;
    }

    @Override
    public boolean cancelOrder(int trackingNumber) throws TrackingNumberNotFoundException {
        boolean isCancelled = dao.cancelOrder(trackingNumber);
        if (!isCancelled) {
            throw new TrackingNumberNotFoundException("Tracking number " + trackingNumber + " cannot be cancelled because it does not exist.");
        }
        return isCancelled;
    }

    @Override
    public List<Courier> getAssignedOrder(int employeeID) throws InvalidEmployeeIdException {
        List<Courier> assignedOrders = dao.getAssignedOrder(employeeID);
        if (assignedOrders == null || assignedOrders.isEmpty()) {
            throw new InvalidEmployeeIdException("Employee ID " + employeeID + " does not exist or has no assigned orders.");
        }
        return assignedOrders;
    }
}
