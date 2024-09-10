package com.example;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.admin.Admin;
import com.example.data.EmployeeDAO;
import com.example.entity.Employee;
@Controller
public class MainController {
	
	@Autowired
	private EmployeeDAO repo;
	
	@RequestMapping("/home")
	public String home() {
		return "home";
	}
	
	@RequestMapping("login")
	public ModelAndView index(ModelAndView model, HttpServletRequest request,
						@RequestParam("username") String username,
						@RequestParam("password") String password) {
		Admin admin = new Admin();
		if (admin.getUsername().equals(username) && 
				admin.getPassword().equals(password)){
			model.setViewName("home");
			return model;
		} else {
			model.addObject("message", "Invalid Login");
			return model;
		}
		
	}
	
	@RequestMapping("/register")
	public String register() {
		return "register";
	}
	
	@RequestMapping("/entry")
	public ModelAndView entry(ModelAndView model,
						@RequestParam("id") String id,
						@RequestParam("name") String name,
						@RequestParam("email") String email,
						@RequestParam("contact") long contact,
						@RequestParam("department") String department) {
		
		if (repo.isPresent(id)) {
			repo.save(new Employee(id, name, email, contact, department));			
			model.addObject("message", "Data Inserted Successfully");
			model.setViewName("message");
			
		} else  {
			model.addObject("message","Data Already Exists");
			model.setViewName("message");
		}
		
		return model;
	}
	
	@RequestMapping("/viewData")
	public ModelAndView viewData(ModelAndView model) {
		
		
		model.addObject("EmployeeData", repo.findAll());
		model.setViewName("viewData");
		
		return model;
	}
	
	@RequestMapping("/update")
	public String update() {
		return "update";
	}
	
	@RequestMapping("updateByID")
	public ModelAndView updateByID(ModelAndView model,
								@RequestParam("id") String id) {
		List<Employee> data = repo.findByID(id).stream().collect(Collectors.toList());
		if(data != null && !data.isEmpty()) {
			
			model.addObject("EmployeeData", data);
			model.setViewName("updatePage");
		} else {
			model.addObject("message", "No data found");
			model.setViewName("message");
		}
		
		return model;
	}
	
	@RequestMapping("/updateAction")
	public ModelAndView updateAction(ModelAndView model,
								@RequestParam("id") String id,
								@RequestParam("name") String name,
								@RequestParam("email") String email,
								@RequestParam("contact") long contact,
								@RequestParam("department") String department) {
		
		Employee employee = new Employee(id, name, email, contact, department);
		
		repo.updateByID(employee);
		
		model.addObject("message", "Data Updated Successfully");
		model.setViewName("message");
		
		return model;
		
	}
	
	@RequestMapping("/delete")
	public String delete() {
		return "deleteByID";
	}
	
	@RequestMapping("deleteByID")
	public ModelAndView deleteByID(ModelAndView model, 
								@RequestParam("id") String id) {
		
		try {
			repo.deleteByID(id);
			model.addObject("message", "Deleted Successfully");
			model.setViewName("message");
		} catch(EmptyResultDataAccessException | EntityNotFoundException e) {
			model.addObject("message", "Deletion Failed");
			model.setViewName("message");
		}
		
		
		return model;
	}
	
	@RequestMapping("/search")
	public ModelAndView search(ModelAndView model, @RequestParam("id") String id) {
			model.addObject("EmployeeData", repo.findByID(id).stream().collect(Collectors.toList()));
			model.setViewName("employeeData");
			return model;		
	}
	
}
