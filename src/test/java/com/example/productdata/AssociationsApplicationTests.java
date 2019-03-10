package com.example.productdata;

import com.example.productdata.Entity.Customer;
import com.example.productdata.Entity.PhoneNumber;
import com.example.productdata.Repository.CustomerRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Set;

// Associations
@RunWith(SpringRunner.class)
@SpringBootTest
public class AssociationsApplicationTests {

    @Autowired
    CustomerRepository repository;

    @Test
    public void contextLoads() {
    }

    @Test
    public void testCreateCustomer() {
        Customer customer = new Customer();
        customer.setName("Rambo");
//        HashSet<PhoneNumber> numbers = new HashSet<PhoneNumber>();
        PhoneNumber ph1 = new PhoneNumber();
        ph1.setPhonenumber("555555555");
        ph1.setType("cellphone");
//        ph1.setCustomer(customer);

        PhoneNumber ph2 = new PhoneNumber();
        ph2.setPhonenumber("123456789");
        ph2.setType("home phone number");
//        ph2.setCustomer(customer);

//        numbers.add(ph1);
//        numbers.add(ph2);
//        customer.setNumbers(numbers);
        customer.addPhonenumber(ph1);
        customer.addPhonenumber(ph2);
        repository.save(customer);
    }

    @Test
    public void testLoadCustomer() {
        Customer customer = repository.findById(4L).get();
        System.out.println(customer.getName());
        Set<PhoneNumber> numbers = customer.getNumbers();
        numbers.forEach(number -> System.out.println(number.getPhonenumber()));
    }

    @Test
    public void testUpdateCustomer() {
        Customer customer = repository.findById(4L).get();
        customer.setName("John");
        Set<PhoneNumber> numbers = customer.getNumbers();
        numbers.forEach(number -> number.setType("cell"));
        repository.save(customer);
    }
}
