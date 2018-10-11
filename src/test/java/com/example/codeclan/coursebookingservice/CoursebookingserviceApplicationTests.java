package com.example.codeclan.coursebookingservice;

import com.example.codeclan.coursebookingservice.models.Course;
import com.example.codeclan.coursebookingservice.models.Customer;
import com.example.codeclan.coursebookingservice.repositories.courserepository.CourseRepository;
import com.example.codeclan.coursebookingservice.repositories.customerrepository.CustomerRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static junit.framework.TestCase.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CoursebookingserviceApplicationTests {

	@Autowired
	CustomerRepository customerRepository;

	@Autowired
	CourseRepository courseRepository;

	@Test
	public void contextLoads() {
	}

	@Test
	public void canGetCourseFromRating() {
		List<Course> found = courseRepository.getCourseByRating(5);
		assertEquals(1, found.size());

	}

	@Test
	public void canGetCustomerFromCourse() {
		List<Customer> found = customerRepository.getAllCustomersFromCourse(1L);
		assertEquals(1, found.size());
	}

	@Test
	public void canGetCustomerFromCourseAndTown() {
		List<Customer> found = customerRepository.GetAllCustomersFromTownAndCourse("Glasgow", 1L);
		assertEquals(1, found.size());
	}
}

