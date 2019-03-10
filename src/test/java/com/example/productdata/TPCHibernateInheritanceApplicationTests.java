package com.example.productdata;

import com.example.productdata.Entity.singletable.Check;
import com.example.productdata.Entity.singletable.CreditCard;
import com.example.productdata.Entity.tableperclass.Bankcheck;
import com.example.productdata.Entity.tableperclass.Card;
import com.example.productdata.Repository.PaymentTPCRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

// Inheritance Table per Class
@RunWith(SpringRunner.class)
@SpringBootTest
public class TPCHibernateInheritanceApplicationTests {

    @Autowired
    PaymentTPCRepository repository;

    @Test
    public void contextLoads() {
    }

    @Test
    public void createTPCCreditCardPayment() {
        Card cc = new Card();
        cc.setCardnumber("1232132131");
        cc.setId(1233);
        cc.setAmount(1000d);
        repository.save(cc);
    }

    @Test
    public void createTPCCheckPayment() {
        Bankcheck cc = new Bankcheck();
        cc.setChecknumber("1232132131");
        cc.setId(12243);
        cc.setAmount(1000d);
        repository.save(cc);
    }
}
