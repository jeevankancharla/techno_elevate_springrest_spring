package com.te.springrest.bean;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonRootName;

import lombok.Data;

@Data
@Entity
@Table(name = "employee_info")
@JsonRootName("employee-info")
@JsonPropertyOrder({"id","name"})
@XmlRootElement(name = "employee-info")
public class EmployeeBean implements Serializable {

	@Id
	@Column
	@JsonProperty("emp_id")
	private Integer id;
	@Column
	private String name;
	@Column

	private Date dob;
	
	
	@Column
	private String password;

}
