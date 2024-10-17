package com.hexaware.couriermanagement.service;

import com.hexaware.couriermanagement.dao.CourierAdminDaoImp;
import com.hexaware.couriermanagement.dao.ICourierAdminDao;
import com.hexaware.couriermanagement.entity.Employee;


public class CourierAdminServiceImp implements  ICourierAdminService{

	private ICourierAdminDao dao;
	
	public CourierAdminServiceImp() {
		dao = new CourierAdminDaoImp();
	}
	
	
	@Override
	public int addCourierStaff(Employee emp) {
		
		return dao.addCourierStaff( emp);
	}


	@Override
	public Employee getByEid(int eid) {

	return dao.getByEid( eid);
	}

}
