package com.example.productdata.Repository;

import com.example.productdata.Entity.BankAccount;
import org.springframework.data.repository.CrudRepository;

public interface BankAccountRepository extends CrudRepository<BankAccount, Integer> {}
