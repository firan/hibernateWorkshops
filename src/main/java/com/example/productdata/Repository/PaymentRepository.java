package com.example.productdata.Repository;

import com.example.productdata.Entity.Payment;
import org.springframework.data.repository.CrudRepository;

public interface PaymentRepository extends CrudRepository<Payment, Integer> {}
