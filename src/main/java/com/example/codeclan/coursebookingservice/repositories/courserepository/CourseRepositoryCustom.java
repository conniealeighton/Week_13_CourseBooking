package com.example.codeclan.coursebookingservice.repositories.courserepository;

import com.example.codeclan.coursebookingservice.models.Course;

import java.util.List;

public interface CourseRepositoryCustom {

    List<Course> getCourseByRating(int rating);

    List<Course> getCourseFromCustomer(Long id);

}
