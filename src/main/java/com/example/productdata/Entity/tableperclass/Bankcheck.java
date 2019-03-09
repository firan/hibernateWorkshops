package com.example.productdata.Entity.tableperclass;

import javax.persistence.Entity;

@Entity
public class Bankcheck extends PaymentTPC {
    private String checknumber;

    public String getChecknumber() {
        return checknumber;
    }

    public void setChecknumber(String checknumber) {
        this.checknumber = checknumber;
    }
}
