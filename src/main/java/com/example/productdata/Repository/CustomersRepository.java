package com.example.productdata.Repository;

import com.example.productdata.Entity.Customers;
import com.example.productdata.Entity.MoviesCopies;
import org.springframework.data.repository.CrudRepository;

public interface CustomersRepository extends CrudRepository<Customers, Integer> {
}
