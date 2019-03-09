package com.example.productdata.Entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("ch")
public class Check extends Payment {
    private String checknumber;

    public String getChecknumber() {
        return checknumber;
    }

    public void setChecknumber(String checknumber) {
        this.checknumber = checknumber;
    }
}
