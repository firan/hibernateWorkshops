package com.example.productdata.Repository;

import com.example.productdata.Entity.Contact;
import org.springframework.data.repository.CrudRepository;

public interface ContactRepository extends CrudRepository<Contact, Long> {
}
