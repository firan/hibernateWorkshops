package com.example.productdata;

import com.example.productdata.Entity.Product;
import com.example.productdata.Repository.ProductRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import javax.swing.*;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductdataApplicationTests {

    @Autowired
    ProductRepository repository;

    @Test
    public void contextLoads() {
    }

    @Test
    public void testCreate() {
        Product product = new Product();
        product.setId(1);
        product.setName("IphoneX");
        product.setDesc("Awesome");
        product.setPrice(1000d);

        repository.save(product);
    }

    @Test
    public void testRead() {
        Product product = repository.findById(1).get();
        assertNotNull(product);
        assertEquals("IphoneX", product.getName());
        System.out.println(product.getDesc());
    }

    @Test
    public void testUpdate() {
        Product product = repository.findById(1).get();
        product.setPrice(200d);
        repository.save(product);
    }

    @Test
    public void testDelete() {
        Product product = repository.findById(1).get();
        if (repository.existsById(1)) {
            repository.deleteById(1);
        }
    }

    @Test
    public void testCount() {
        System.out.println(repository.count());
    }

    @Test
    public void testFindByName() {
        List<Product> products = repository.findByName("Dryer");
        products.forEach(p -> System.out.println(p.getPrice()));
    }

    @Test
    public void testFindAllPaging() {
        Pageable pageable = PageRequest.of(1, 2);
        Page<Product> results = repository.findAll(pageable);
        results.forEach(p -> System.out.println(p.getName()));
    }

    @Test
    public void testFindAllSorting() {
        Sort sortable = Sort.by(Sort.Direction.DESC, "name");
        repository.findAll(sortable).forEach(p -> System.out.println(p.getName()));
    }

    @Test
    public void testFindAllPagingAndSorting() {
        Pageable pageable = PageRequest.of(1, 2, Sort.Direction.DESC, "name");
        repository.findAll(pageable).forEach(p -> System.out.println(p.getName()));
    }
}