package com.cognizant.springrest.DAO;

import java.util.Iterator;
import java.util.List;

import com.cognizant.springrest.model.Employee;

public class EmployeeDao {

	private static List<Employee> EMPLOYEE_LIST;
	
	public List<Employee> getList() {
		return EMPLOYEE_LIST;
	}

	public void setList(List<Employee> EMPLOYEE_LIST) {
		EmployeeDao.EMPLOYEE_LIST = EMPLOYEE_LIST;
	}

	public EmployeeDao() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EmployeeDao(List<Employee> emp_list) {
		super();
		EmployeeDao.EMPLOYEE_LIST = emp_list;
	}

	public List<Employee> getAllEmployees() {
		return EMPLOYEE_LIST;
	}

	public void UpdateEmployee(Employee employee) {
		for (Employee emp : EMPLOYEE_LIST) {
			if (emp.getEmpId().equalsIgnoreCase(employee.getEmpId())) {
				emp.setPermanent(employee.getPermanent());
			}
		}
	}

	public void deleteEmployee(String id) {
		Iterator<Employee> iterator = EMPLOYEE_LIST.iterator();
		while (iterator.hasNext()) {
			Employee emp = (Employee) iterator.next();
			if (emp.getEmpId().equalsIgnoreCase(id)) {
				iterator.remove();
			}
		}

	}
}
