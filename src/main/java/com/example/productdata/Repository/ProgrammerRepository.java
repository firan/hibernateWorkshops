package com.example.productdata.Repository;

import com.example.productdata.Entity.Programmer;
import org.springframework.data.repository.CrudRepository;

public interface ProgrammerRepository extends CrudRepository<Programmer, Integer> { }
