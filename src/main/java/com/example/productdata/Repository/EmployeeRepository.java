package com.example.productdata.Repository;


import com.example.productdata.Entity.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {}