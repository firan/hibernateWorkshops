package com.example.productdata.Repository;

import com.example.productdata.Entity.singletable.PaymentST;
import com.example.productdata.Entity.tableperclass.PaymentTPC;
import org.springframework.data.repository.CrudRepository;

public interface PaymentTPCRepository extends CrudRepository<PaymentTPC, Integer> {}
