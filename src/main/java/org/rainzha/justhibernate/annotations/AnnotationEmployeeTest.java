package org.rainzha.justhibernate.annotations;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class AnnotationEmployeeTest {
    private SessionFactory sessionFactory = null;

    private void initSessionFactory() {
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    private void persistEmployee() {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Employee emp = new Employee();
        emp.setName("M Konda");

        session.save(emp);

        session.getTransaction().commit();
    }


    public static void main(String[] args) {
        AnnotationEmployeeTest p = new AnnotationEmployeeTest();
        p.initSessionFactory();
        p.persistEmployee();

        p.sessionFactory.close();
    }
}
