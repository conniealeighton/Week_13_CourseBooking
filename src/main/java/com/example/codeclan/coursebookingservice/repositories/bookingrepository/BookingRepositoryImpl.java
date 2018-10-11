package com.example.codeclan.coursebookingservice.repositories.bookingrepository;

import com.example.codeclan.coursebookingservice.models.Booking;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

public class BookingRepositoryImpl implements  BookingRepositoryCustom {

    @Autowired
    EntityManager entityManager;

//    Get all bookings for a given date

    @Transactional
    public List<Booking> getAllBookingForDate(String date){
        List<Booking> results = null;
        Session session = entityManager.unwrap(Session.class);
        try {
            Criteria cr = session.createCriteria(Booking.class);
            cr.add(Restrictions.eq("date", date));
            results = cr.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return results;
    }

}
