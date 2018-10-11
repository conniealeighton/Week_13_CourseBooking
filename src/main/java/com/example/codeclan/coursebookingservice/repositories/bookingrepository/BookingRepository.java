package com.example.codeclan.coursebookingservice.repositories.bookingrepository;

import com.example.codeclan.coursebookingservice.models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long>, BookingRepositoryCustom{
}
