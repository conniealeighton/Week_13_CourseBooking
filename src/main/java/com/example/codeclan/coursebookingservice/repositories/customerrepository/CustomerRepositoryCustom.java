package com.example.codeclan.coursebookingservice.repositories.customerrepository;

import com.example.codeclan.coursebookingservice.models.Course;
import com.example.codeclan.coursebookingservice.models.Customer;

import java.util.List;

public interface CustomerRepositoryCustom {
    List<Customer> getAllCustomersFromCourse(Long id);
}
