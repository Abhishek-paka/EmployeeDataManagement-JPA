package com.example.data;

import java.util.List;
import java.util.Optional;

import com.example.entity.Employee;

public interface EmployeeDAO {
	public void save(Employee employee);
	public List<Employee> findAll();
	public Optional<Employee> findByID(String id);
	public void updateByID(Employee employee);
	public void deleteByID(String id);
	public boolean isPresent(String id);
}
