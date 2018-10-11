package com.example.codeclan.coursebookingservice.repositories.courserepository;

import com.example.codeclan.coursebookingservice.models.Booking;
import com.example.codeclan.coursebookingservice.models.Course;
import com.example.codeclan.coursebookingservice.repositories.bookingrepository.BookingRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long>, CourseRepositoryCustom {
}
