package com.te.springrest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.te.springrest.bean.EmployeeBean;
import com.te.springrest.bean.EmployeeResponse;
import com.te.springrest.service.EmployeeService;

@RestController
public class EmployeeRestController {

	@Autowired
	EmployeeService service;

	@GetMapping(path = "/getEmp", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public EmployeeBean getEmp(int id) {

		EmployeeBean bean = service.getEmployee(id);
		if (bean != null) {
			return bean;
		} else {
			return null;
		}

	}//end of get emp
	
	
	@DeleteMapping(path = "/delete/{emp_id}", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public EmployeeResponse deleteEmp(@PathVariable(name = "emp_id") int id) {
		EmployeeResponse employeeResponse = new EmployeeResponse();
		if (service.deleteEmp(id)) {
			employeeResponse.setStatusCode(200);
			employeeResponse.setMsg("success");
			employeeResponse.setDescription(" Data Deleted for id : " + id);
		} else {
			employeeResponse.setStatusCode(400);
			employeeResponse.setMsg("failure");
			employeeResponse.setDescription(" Data Not for id : " + id);
		}

		return employeeResponse;
	}//

	@PostMapping(path = "/add", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	public EmployeeResponse addEmp(@RequestBody EmployeeBean employeeBean) {
		EmployeeResponse response = new EmployeeResponse();
		if (service.addEmployee(employeeBean)) {
			response.setStatusCode(200);
			response.setMsg("success");
			response.setDescription("Added Successfully");
		} else {
			response.setStatusCode(400);
			response.setMsg("failure");
			response.setDescription("Something Went Wrong");
		}
		return response;
	}//

	@PutMapping(path = "/update", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	public EmployeeResponse updateEmp(@RequestBody EmployeeBean bean) {
		System.out.println(bean);
		EmployeeResponse response = new EmployeeResponse();
		if (service.updateEmployee(bean)) {
			response.setStatusCode(200);
			response.setMsg("success");
			response.setDescription("Added Successfully");
		} else {
			response.setStatusCode(400);
			response.setMsg("failure");
			response.setDescription("Something Went Wrong");
		}
		return response;
	}
	
	@GetMapping(path = "/getAll", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public EmployeeResponse getAll() {
		EmployeeResponse response = new EmployeeResponse();
		List<EmployeeBean> employeeBeans = service.getAllEmp();
		if (employeeBeans != null) {
			response.setStatusCode(200);
			response.setMsg("success");
			response.setDescription("Employee details found");
			response.setEmployeeBeans(employeeBeans);
		} else {
			response.setStatusCode(400);
			response.setMsg("failure");
			response.setDescription("Details Not found");
		}
		return response;
	}
	
}
