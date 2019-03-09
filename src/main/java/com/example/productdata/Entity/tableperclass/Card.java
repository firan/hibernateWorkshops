package com.example.productdata.Entity.tableperclass;

import javax.persistence.Entity;

@Entity
public class Card extends PaymentTPC {
    private String cardnumber;

    public String getCardnumber() {
        return cardnumber;
    }

    public void setCardnumber(String cardnumber) {
        this.cardnumber = cardnumber;
    }
}
