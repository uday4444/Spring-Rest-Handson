package com.cognizant.springrest.DAO;

import java.util.List;

import com.cognizant.springrest.model.Department;

public class DepartmentDao {

	private static List<Department> list;

	public DepartmentDao() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DepartmentDao(List<Department> dept_list) {
		super();
		this.list = dept_list;
	}
	
	
	public List<Department> getList() {
		return list;
	}

	public void setList(List<Department> list) {
		this.list = list;
	}
}
