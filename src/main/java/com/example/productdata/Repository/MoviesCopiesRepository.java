package com.example.productdata.Repository;

import com.example.productdata.Entity.MoviesCopies;
import com.example.productdata.Entity.MoviesInfo;
import org.springframework.data.repository.CrudRepository;

public interface MoviesCopiesRepository extends CrudRepository<MoviesCopies, Integer> {
}
