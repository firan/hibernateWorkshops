package com.example.productdata;

import com.example.productdata.Service.BankAccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

// Transaction Management
@RunWith(SpringRunner.class)
@SpringBootTest
public class TransactionManagementApplicationTests {

    @Autowired
    BankAccountService service;

    @Test
    public void contextLoads() {
    }

    @Test
    public void testTransfer(){
        service.transfer(200);
    }
}
