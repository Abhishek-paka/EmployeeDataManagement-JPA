package com.example.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Employee")
public class Employee {

	@Id
	@Column(name ="Employee_ID")
	private String id;
	
	@Column(name ="Employee_NAME")
	private String name;
	
	@Column(name ="EMAIL")
	private String email;
	
	@Column(name ="CONTACT")
	private long contact;
	
	@Column(name ="DEPARTMENT")
	private String department;

	public Employee() {
	}

	public Employee(String id, String name, String email, long contact, String department) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.contact = contact;
		this.department = department;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getContact() {
		return contact;
	}

	public void setContact(long contact) {
		this.contact = contact;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", email=" + email + ", contact=" + contact + ", department="
				+ department + "]";
	}

}