package com.example.productdata.Service;

import com.example.productdata.Entity.BankAccount;
import com.example.productdata.Repository.BankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BankAccountServiceImpl implements BankAccountService {

    final BankAccountRepository repository;

    // Always inject to constructor
    @Autowired
    public BankAccountServiceImpl(BankAccountRepository repository) {
        this.repository = repository;
    }

    @Override
//    @Transactional
    public void transfer(int amount) {
        BankAccount obamasAccount = repository.findById(1).get();
        obamasAccount.setBal(obamasAccount.getBal() - amount);
        repository.save(obamasAccount);

//        if(true) {
//            throw new RuntimeException();
//        }

        BankAccount trumpsAccount = repository.findById(2).get();
        trumpsAccount.setBal(trumpsAccount.getBal() + amount);
        repository.save(trumpsAccount);
    }
}