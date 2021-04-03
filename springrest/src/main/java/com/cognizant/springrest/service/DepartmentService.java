package com.cognizant.springrest.service;

import java.util.List;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.cognizant.springrest.DAO.DepartmentDao;
import com.cognizant.springrest.model.Department;



@Service
public class DepartmentService {
	
	public List<Department> getAllDepartment()
	{
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("employee.xml");
		DepartmentDao depDao = context.getBean("deptList", DepartmentDao.class);
		List<Department> list = depDao.getList();
		return list;
	}

}