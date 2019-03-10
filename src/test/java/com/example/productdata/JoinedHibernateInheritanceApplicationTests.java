package com.example.productdata;

import com.example.productdata.Entity.joined.Jbankcheck;
import com.example.productdata.Entity.joined.Jcard;
import com.example.productdata.Entity.tableperclass.Bankcheck;
import com.example.productdata.Entity.tableperclass.Card;
import com.example.productdata.Repository.JPaymentRepository;
import com.example.productdata.Repository.PaymentTPCRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

// Inheritance Joined
@RunWith(SpringRunner.class)
@SpringBootTest
public class JoinedHibernateInheritanceApplicationTests {

    @Autowired
    JPaymentRepository repository;

    @Test
    public void contextLoads() {
    }

    @Test
    public void createJoinedCreditCardPayment() {
        Jcard cc = new Jcard();
        cc.setCardnumber("1232132131");
        cc.setId(1233);
        cc.setAmount(1000d);
        repository.save(cc);
    }

    @Test
    public void createJoinedCheckPayment() {
        Jbankcheck cc = new Jbankcheck();
        cc.setChecknumber("1232132131");
        cc.setId(12243);
        cc.setAmount(1000d);
        repository.save(cc);
    }
}
