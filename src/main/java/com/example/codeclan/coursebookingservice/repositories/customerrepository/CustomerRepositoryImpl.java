package com.example.codeclan.coursebookingservice.repositories.customerrepository;

import com.example.codeclan.coursebookingservice.models.Course;
import com.example.codeclan.coursebookingservice.models.Customer;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.hibernate.usertype.CompositeUserType;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

public class CustomerRepositoryImpl implements  CustomerRepositoryCustom{

    @Autowired
    EntityManager entityManager;


//    Get all customers for a given course
    @Transactional
    public List<Customer> getAllCustomersFromCourse(Long id){
        List<Customer> results = null;
        Session session = entityManager.unwrap(Session.class);
        try {
            Criteria cr = session.createCriteria(Customer.class);
            cr.createAlias("bookings", "booking");
            cr.createAlias("booking.course", "course");
//            cr.createAlias("bookings.course", "course");
            cr.add(Restrictions.eq("course.id", id));
            results = cr.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return results;
    }

//    Get all customers in a given town for a given course

    @Transactional
    public List<Customer> GetAllCustomersFromTownAndCourse(String town, Long id){
        List<Customer> results = null;
        Session session = entityManager.unwrap(Session.class);
        try {
            Criteria cr = session.createCriteria(Customer.class);
            cr.createAlias("bookings", "booking");
            cr.createAlias("booking.course", "course");
            cr.add(Restrictions.eq("course.id", id));
            cr.add(Restrictions.eq("town", town).ignoreCase());
            results = cr.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return results;
    }

//    Get all customers over a certain age in a given town for a given course

    @Transactional
    public List<Customer> getAllCustomersFromTownAndCourseOverAge(int age, String town, Long courseId) {
        List<Customer> results = null;
        Session session = entityManager.unwrap(Session.class);
        try {
            Criteria cr = session.createCriteria(Customer.class);
            cr.createAlias("bookings", "booking");
            cr.createAlias("booking.course", "course");
            cr.add(Restrictions.eq("course.id", courseId));
            cr.add(Restrictions.eq("town", town).ignoreCase());
            cr.add(Restrictions.gt("age", age));
            results = cr.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return results;
    }
}


