package com.cognizant.springrest.model;

public class Employee {

	private String empId;
	
	private String empName;
	
	private String permanent;
	
	private int salary;
	
	private String dateOfBirth;
	
	private Department dept;

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(String empId, String empName, String permanent, int salary, String dateOfBirth, Department dept) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.permanent = permanent;
		this.salary = salary;
		this.dateOfBirth = dateOfBirth;
		this.dept = dept;
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getPermanent() {
		return permanent;
	}

	public void setPermanent(String permanent) {
		this.permanent = permanent;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Department getDept() {
		return dept;
	}

	public void setDept(Department dept) {
		this.dept = dept;
	}

	
	
	
}
