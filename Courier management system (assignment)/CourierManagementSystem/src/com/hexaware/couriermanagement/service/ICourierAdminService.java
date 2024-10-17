package com.hexaware.couriermanagement.service;


import com.hexaware.couriermanagement.entity.Employee;


public interface ICourierAdminService {
	

	int addCourierStaff(Employee emp);
	Employee      getByEid(int eid);
	
}
