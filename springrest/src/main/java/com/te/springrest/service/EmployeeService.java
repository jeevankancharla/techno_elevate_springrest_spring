package com.te.springrest.service;

import java.util.List;

import com.te.springrest.bean.EmployeeBean;

public interface EmployeeService {
	
public EmployeeBean getEmployee(int id);
	
	public boolean deleteEmp(int id);
	
   public List<EmployeeBean> getAllEmp();
   
   public boolean addEmployee(EmployeeBean bean);
   
   public boolean updateEmployee(EmployeeBean bean);

}
