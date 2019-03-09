package com.example.productdata;

import com.example.productdata.Entity.singletable.Check;
import com.example.productdata.Entity.singletable.CreditCard;
import com.example.productdata.Repository.PaymentSTRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class STHibernateInheritanceApplicationTests {

    @Autowired
    PaymentSTRepository repository;

    @Test
    public void contextLoads() {
    }

    @Test
    public void createSTCreditCardPayment() {
        CreditCard cc = new CreditCard();
        cc.setCardnumber("1232132131");
        cc.setId(1233);
        cc.setAmount(1000d);
        repository.save(cc);
    }

    @Test
    public void createSTCheckPayment() {
        Check cc = new Check();
        cc.setChecknumber("1232132131");
        cc.setId(12243);
        cc.setAmount(1000d);
        repository.save(cc);
    }
}
