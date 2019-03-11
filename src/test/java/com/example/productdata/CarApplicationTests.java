package com.example.productdata;

import com.example.productdata.Repository.CarRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

// EntityManager
@RunWith(SpringRunner.class)
@SpringBootTest
public class CarApplicationTests {

    @Autowired
    CarRepository repository;

    @Test
    public void contextLoads() {
    }

    @Test
    public void testCreateEmployee(){
        repository.createCar("A6", "Audi", 230);
    }
}
