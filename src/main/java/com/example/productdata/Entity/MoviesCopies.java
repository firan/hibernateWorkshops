package com.example.productdata.Entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "moviesCopies")
public class MoviesCopies {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "copyId")
    private int copyId;

    @Column(name = "isRented")
    private boolean isRented;

    @Column(name = "rentedTo")
    private int rentedTo;

    @ManyToOne
    @JoinColumn(name = "movieInfoId")
    private MoviesInfo movieInfo;

    @OneToMany(mappedBy = "movieCopy", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Rents> rents;

    public List<Rents> getRents() {
        return rents;
    }

    public void setRents(List<Rents> rents) {
        this.rents = rents;
    }

    public int getCopyId() {
        return copyId;
    }

    public void setCopyId(int copyId) {
        this.copyId = copyId;
    }

    public boolean isRented() {
        return isRented;
    }

    public void setRented(boolean rented) {
        isRented = rented;
    }

    public int getRentedTo() {
        return rentedTo;
    }

    public void setRentedTo(int rentedTo) {
        this.rentedTo = rentedTo;
    }

    public MoviesInfo getMovieInfo() {
        return movieInfo;
    }

    public void setMovieInfo(MoviesInfo movieInfo) {
        this.movieInfo = movieInfo;
    }

    public MoviesCopies() {}

    public MoviesCopies(boolean isRented, int rentedTo, MoviesInfo movieInfo) {
        this.isRented = isRented;
        this.rentedTo = rentedTo;
        this.movieInfo = movieInfo;
    }
}