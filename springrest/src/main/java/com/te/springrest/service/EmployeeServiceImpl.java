package com.te.springrest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.te.springrest.bean.EmployeeBean;
import com.te.springrest.dao.EmployeeDAO;
@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
private EmployeeDAO dao;

	
	@Override
	public EmployeeBean getEmployee(int id) {
		// TODO Auto-generated method stub
		return dao.getEmployee(id);
	}

	@Override
	public boolean deleteEmp(int id) {
		// TODO Auto-generated method stub
		return dao.deleteEmp(id);
	}

	@Override
	public List<EmployeeBean> getAllEmp() {
		// TODO Auto-generated method stub
		return dao.getAllEmp();
	}

	@Override
	public boolean addEmployee(EmployeeBean bean) {
		// TODO Auto-generated method stub
		return dao.addEmployee(bean);
	}

	@Override
	public boolean updateEmployee(EmployeeBean bean) {
		// TODO Auto-generated method stub
		return dao.updateEmployee(bean);
	}

}
