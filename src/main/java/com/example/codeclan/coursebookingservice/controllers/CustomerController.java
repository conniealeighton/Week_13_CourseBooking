package com.example.codeclan.coursebookingservice.controllers;

import com.example.codeclan.coursebookingservice.models.Booking;
import com.example.codeclan.coursebookingservice.models.Course;
import com.example.codeclan.coursebookingservice.models.Customer;
import com.example.codeclan.coursebookingservice.repositories.courserepository.CourseRepository;
import com.example.codeclan.coursebookingservice.repositories.customerrepository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/customers")
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;

    @GetMapping(value = "/{id}/course")
    public List<Customer> getAllCustomersFromCourse(@PathVariable Long id){
        return customerRepository.getAllCustomersFromCourse(id);
    }
//"/town/{town}/course/{id}"
    @GetMapping(value = "{id}/town/{town}")
    public List<Customer> GetAllCustomersFromTownAndCourse(@PathVariable String town, @PathVariable Long id){
        return customerRepository.GetAllCustomersFromTownAndCourse(town, id);
    }

    @GetMapping(value = "/{courseId}/town/{town}/age/{age}")
    public List<Customer> getAllCustomersFromTownAndCourseOverAge(@PathVariable int age, @PathVariable String town, @PathVariable Long courseId){
        return customerRepository.getAllCustomersFromTownAndCourseOverAge(age, town, courseId);
    }


}


