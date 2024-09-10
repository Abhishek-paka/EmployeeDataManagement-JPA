package com.example.data;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.Employee;

public interface JPARepo extends JpaRepository<Employee, String> {

}
