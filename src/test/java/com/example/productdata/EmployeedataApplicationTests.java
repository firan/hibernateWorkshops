package com.example.productdata;

import com.example.productdata.Entity.Address;
import com.example.productdata.Entity.Employee;
import com.example.productdata.Entity.Product;
import com.example.productdata.Repository.EmployeeRepository;
import com.example.productdata.Repository.ProductRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

// Component Mapping
@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeedataApplicationTests {

    @Autowired
    EmployeeRepository repository;

    @Test
    public void contextLoads() {
    }

    @Test
    public void testCreateEmployee(){
        Employee employee = new Employee();
        employee.setName("Albin");
        employee.setId(2);
        Address address = new Address();
        address.setStreetaddress("Mokotowska");
        address.setCity("Warsaw");
        address.setState("Mazowieckie");
        address.setCountry("Poland");
        address.setZipcode("01-601");
        employee.setAddress(address);
        repository.save(employee);
    }
}
