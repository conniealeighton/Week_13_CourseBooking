package com.example.codeclan.coursebookingservice.components;

import com.example.codeclan.coursebookingservice.models.Booking;
import com.example.codeclan.coursebookingservice.models.Course;
import com.example.codeclan.coursebookingservice.models.Customer;
import com.example.codeclan.coursebookingservice.repositories.bookingrepository.BookingRepository;
import com.example.codeclan.coursebookingservice.repositories.courserepository.CourseRepository;
import com.example.codeclan.coursebookingservice.repositories.customerrepository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    CourseRepository courseRepsository;

    @Autowired
    CustomerRepository customerRepository;

    public DataLoader() {
    }

    public void run(ApplicationArguments args){
        Course course = new Course("intro to programming", "glasgow", 5);
        courseRepsository.save(course);

        Customer customer = new Customer("Tanny", "Glasgow", 18);
        customerRepository.save(customer);

        Booking booking = new Booking("11-09-18", course, customer);
        bookingRepository.save(booking);

    }
}
