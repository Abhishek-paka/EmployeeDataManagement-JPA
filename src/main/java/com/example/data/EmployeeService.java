package com.example.data;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Employee;

@Service
public class EmployeeService implements EmployeeDAO {
	
	@Autowired
	private JPARepo repo;
	
	public void save(Employee employee) {
		repo.save(employee);
	}
	
	public List<Employee> findAll(){
		return repo.findAll();
	}
	
	public Optional<Employee> findByID(String id){
		return repo.findById(id);
	}
	
	public void updateByID(Employee employee) {
		repo.save(employee);
	}
	
	public void deleteByID(String id) {
		repo.deleteById(id);
	}
	
	public boolean isPresent(String id) {
		if (!repo.findById(id).isEmpty()) {
			return false;
		}
		return true;
	}

}
