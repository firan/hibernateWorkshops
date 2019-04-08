package com.example.productdata.Entity;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "moviesInfo")
public class MoviesInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "movieInfoId")
    private int movieInfoId;

    @Column(name = "title")
    private String title;

    @Column(name = "genre")
    private String genre;

    @Column(name = "releaseDate")
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime releaseDate;

    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "movieInfo", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<MoviesCopies> copies;


    public int getMovieInfoId() {
        return movieInfoId;
    }

    public void setMovieInfoId(int movieInfoId) {
        this.movieInfoId = movieInfoId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public DateTime getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(DateTime releaseDate) {
        this.releaseDate = releaseDate;
    }

    public MoviesInfo() {}

    public MoviesInfo(String title, String genre, DateTime releaseDate, String description) {
        this.title = title;
        this.genre = genre;
        this.releaseDate = releaseDate;
        this.description = description;
    }

    public Set<MoviesCopies> getCopies() {
        return copies;
    }

    public void setCopies(Set<MoviesCopies> copies) {
        this.copies = copies;
    }
}