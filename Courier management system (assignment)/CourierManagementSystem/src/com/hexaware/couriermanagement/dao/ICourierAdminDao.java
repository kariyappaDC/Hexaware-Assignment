package com.hexaware.couriermanagement.dao;

import com.hexaware.couriermanagement.entity.Employee;

public interface ICourierAdminDao {
	
	int addCourierStaff(Employee emp);
	Employee      getByEid(int eid);

}
