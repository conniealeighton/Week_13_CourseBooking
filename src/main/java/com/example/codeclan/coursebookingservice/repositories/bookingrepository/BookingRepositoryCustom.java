package com.example.codeclan.coursebookingservice.repositories.bookingrepository;

import com.example.codeclan.coursebookingservice.models.Booking;
import com.example.codeclan.coursebookingservice.models.Customer;

import java.util.List;

public interface BookingRepositoryCustom {
    List<Booking> getAllBookingForDate(String date);
}
