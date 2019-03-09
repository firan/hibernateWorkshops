package com.example.productdata;

import com.example.productdata.Entity.Check;
import com.example.productdata.Entity.CreditCard;
import com.example.productdata.Repository.PaymentRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HibernateInheritanceApplicationTests {

    @Autowired
    PaymentRepository repository;

    @Test
    public void contextLoads() {
    }

    @Test
    public void createPayment() {
        CreditCard cc = new CreditCard();
        cc.setCardnumber("1232132131");
        cc.setId(123);
        cc.setAmount(1000d);
        repository.save(cc);
    }

    @Test
    public void createCheckPayment() {
        Check cc = new Check();
        cc.setChecknumber("1232132131");
        cc.setId(1243);
        cc.setAmount(1000d);
        repository.save(cc);
    }
}
