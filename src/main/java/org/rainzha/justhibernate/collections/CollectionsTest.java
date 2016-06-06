package org.rainzha.justhibernate.collections;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.rainzha.justhibernate.collections.list.Showroom;

import java.util.ArrayList;
import java.util.List;

public class CollectionsTest {
    private SessionFactory sessionFactory = null;

    private void initSessionFactory() {
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    private void persistLists() {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();

        // Create showroom object
        Showroom showroom = new Showroom();
        showroom.setLocation("East Croydon, Greater London");
        showroom.setManager("Barry Larry");
        // Create list of cars
        List<Car> cars = new ArrayList<Car>();
        cars.add(new Car("Toyota", "Racing Green"));
        cars.add(new Car("Toyota", "Racing Green"));
        cars.add(new Car("Nissan", "White"));
        cars.add(new Car("BMW", "Black"));
        cars.add(new Car("Mercedes", "Silver"));
        // Associate cars to the showroom
        showroom.setCars(cars);
        // Save the showroom
        session.save(showroom);

        session.getTransaction().commit();
    }

    public static void main(String[] args) {
        CollectionsTest p = new CollectionsTest();
        p.initSessionFactory();

        p.persistLists();

        p.sessionFactory.close();
    }
}
