package com.example.productdata.Entity;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "rents")
public class Rents {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "rentId")
    private int rentId;

    @Enumerated(EnumType.STRING)
    @Column(length = 8, name = "status")
    private RentStatus status;

    @Column(name = "rentPricePerDay")
    private BigDecimal rentPricePerDay;

    @Column(name = "rentedDate")
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime rentedDate;

    @Column(name = "returnedDate")
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime returnedDate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "rentedMovieId")
    private MoviesCopies movieCopy;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "customer")
    private Customers customer;

    public Rents() {}

    public Rents(RentStatus status, BigDecimal rentPricePerDay, DateTime rentedDate, DateTime returnedDate, MoviesCopies movieCopy, Customers customer) {
        this.status = status;
        this.rentPricePerDay = rentPricePerDay;
        this.rentedDate = rentedDate;
        this.returnedDate = returnedDate;
        this.movieCopy = movieCopy;
        this.customer = customer;
    }

    public int getRentId() {
        return rentId;
    }

    public void setRentId(int rentId) {
        this.rentId = rentId;
    }

    public RentStatus getStatus() {
        return status;
    }

    public void setStatus(RentStatus status) {
        this.status = status;
    }

    public BigDecimal getRentPricePerDay() {
        return rentPricePerDay;
    }

    public void setRentPricePerDay(BigDecimal rentPricePerDay) {
        this.rentPricePerDay = rentPricePerDay;
    }

    public DateTime getRentedDate() {
        return rentedDate;
    }

    public void setRentedDate(DateTime rentedDate) {
        this.rentedDate = rentedDate;
    }

    public DateTime getReturnedDate() {
        return returnedDate;
    }

    public void setReturnedDate(DateTime returnedDate) {
        this.returnedDate = returnedDate;
    }

    public MoviesCopies getMovieCopy() {
        return movieCopy;
    }

    public void setMovieCopy(MoviesCopies movieCopy) {
        this.movieCopy = movieCopy;
    }

    public Customers getCustomer() {
        return customer;
    }

    public void setCustomer(Customers customer) {
        this.customer = customer;
    }
}