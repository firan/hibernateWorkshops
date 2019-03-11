package com.example.productdata.Repository;

import com.example.productdata.Entity.Car;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Component
public class CarRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void createCar(String model, String manufacturer, int horsepower){
        Car car = new Car(model, manufacturer, horsepower);
        entityManager.merge(car);
    }
}
