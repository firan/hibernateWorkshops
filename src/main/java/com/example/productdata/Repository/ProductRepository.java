package com.example.productdata.Repository;


import com.example.productdata.Entity.Product;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface ProductRepository extends PagingAndSortingRepository<Product, Integer> {

    List<Product> findByName(String name);
}