package com.example.productdata;

import com.example.productdata.Entity.*;
import com.example.productdata.Repository.ContactRepository;
import com.example.productdata.Repository.LicenseRepository;
import com.example.productdata.Repository.ProgrammerRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

// Associations
@RunWith(SpringRunner.class)
@SpringBootTest
public class AssociationsApplicationTests {

    @Autowired
    ContactRepository contactRepository;

    @Autowired
    ProgrammerRepository programmerRepository;

    @Autowired
    LicenseRepository licenseRepository;

    @Test
    public void contextLoads() {
    }

    @Test
    public void testCreateContact() {
        Contact contact = new Contact();
        contact.setName("Rambo");
        HashSet<PhoneNumber> numbers = new HashSet<PhoneNumber>();
        PhoneNumber ph1 = new PhoneNumber();
        ph1.setPhonenumber("555555555");
        ph1.setType("cellphone");
        ph1.setContact(contact);

        PhoneNumber ph2 = new PhoneNumber();
        ph2.setPhonenumber("123456789");
        ph2.setType("home phone number");
        ph2.setContact(contact);

        numbers.add(ph1);
        numbers.add(ph2);
        contact.setNumbers(numbers);
        contact.addPhonenumber(ph1);
        contact.addPhonenumber(ph2);
        contactRepository.save(contact);
    }

    @Test
    public void testLoadContact() {
        Contact contact = contactRepository.findById(4L).get();
        System.out.println(contact.getName());
        Set<PhoneNumber> numbers = contact.getNumbers();
        numbers.forEach(number -> System.out.println(number.getPhonenumber()));
    }

    @Test
    public void testUpdateContact() {
        Contact contact = contactRepository.findById(4L).get();
        contact.setName("John");
        Set<PhoneNumber> numbers = contact.getNumbers();
        numbers.forEach(number -> number.setType("cell"));
        contactRepository.save(contact);
    }

    @Test
    public void testManyToManyCreateProgrammer(){
        Programmer programmer = new Programmer();
        programmer.setName("Schwarzenegger");
        programmer.setSalary(5000);

        Project project1 = new Project();
        project1.setName("hibernate workshop");

        Project project2 = new Project();
        project2.setName("git workshop");

        HashSet<Project> projects = new HashSet<Project>();
        projects.add(project1);
        projects.add(project2);

        programmer.setProjects(projects);
        programmerRepository.save(programmer);
    }

    @Test
    @Transactional //LazyInitialization, Eager Fetch
    public void testManyToManyFindProgrammer() {
        Programmer programmer = programmerRepository.findById(2).get();
        System.out.println(programmer);
        System.out.println(programmer.getProjects()); // LazyInitialization, Eager Fetch
    }

    @Test
    public void testOneToOneCreateLicense() {
        License license = new License();
        license.setType("CAR");
        license.setValidFrom(new Date());
        license.setValidTo(new Date());

        Person person = new Person();
        person.setAge(29);
        person.setFirstName("Artur");
        person.setLastName("Clinton");

        license.setPerson(person);
        licenseRepository.save(license);
    }
}
