package com.example.productdata;

import com.example.productdata.Entity.*;
import com.example.productdata.Repository.CustomersRepository;
import com.example.productdata.Repository.MoviesCopiesRepository;
import com.example.productdata.Repository.MoviesInfoRepository;
import com.example.productdata.Repository.RentsRepository;
import org.joda.time.DateTime;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;

// Component Mapping
@RunWith(SpringRunner.class)
@SpringBootTest
public class MoviesApplicationTests {

    @Autowired
    MoviesInfoRepository moviesInfoRepository;

    @Autowired
    MoviesCopiesRepository moviesCopiesRepository;

    @Autowired
    CustomersRepository customersRepository;

    @Autowired
    RentsRepository rentsRepository;

    @Test
    public void contextLoads() {
    }

    @Test
    public void testCreateMovieInfo() {
        MoviesInfo movieInfo = new MoviesInfo("Scent of a woman", "drama", new DateTime(DateTime.parse("1992-12-31T00:00:00Z")), "awesome");
        moviesInfoRepository.save(movieInfo);
    }

    @Test
    public void testCreateMovieCopy() {
        MoviesInfo movieInfo = new MoviesInfo("Blinded by the lights", "tv series", new DateTime(DateTime.parse("2018-10-10T00:00:00Z")), "awesome");
        MoviesCopies movieCopy = new MoviesCopies(false, 0, movieInfo);
        movieInfo.setCopies(Collections.singleton(movieCopy));
        moviesInfoRepository.save(movieInfo);
    }

    @Test
    public void testCreateCustomers() {
        Customers customer1 = new Customers("Artur G", "666 666 222", "buziaczek777@gmail.com", "Dolna 22, 11-601 Warszawa");
        Customers customer2 = new Customers("Krzysztof K", "555 666 222", "krzysztof@gmail.com", "Piekna 22, 11-601 Warszawa");
        customersRepository.saveAll(Arrays.asList(customer1, customer2));
    }

    @Test
    public void testCreateRents() {
        Customers customer = customersRepository.findById(1).get();
        MoviesCopies movieCopy = moviesCopiesRepository.findById(47).get();

        Rents rent = new Rents(RentStatus.INRENT, new BigDecimal(3.5), DateTime.now(), DateTime.now().plusDays(3), movieCopy, customer);

        movieCopy.setRented(true);
        moviesCopiesRepository.save(movieCopy);

        rentsRepository.save(rent);
    }

}
