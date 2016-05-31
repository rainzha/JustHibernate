package org.rainzha.justhibernate.basics;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.rainzha.justhibernate.domain.Movie;

import java.util.List;

public class BasicMovieManager {
    private SessionFactory sessionFactory = null;

    public BasicMovieManager() {
        initSessionFactory();
    }

    // Creating SessionFactory using 4.2 version of Hibernate
    private void initSessionFactory() {
        Configuration config = new Configuration().configure();

        ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(
                config.getProperties()).buildServiceRegistry();

        sessionFactory = config.buildSessionFactory(serviceRegistry);
    }

    private void persistMovie(Movie movie) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.save(movie);
        session.getTransaction().commit();
    }

    private void findMovie(int movieId) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Movie movie = (Movie) session.load(Movie.class, movieId);
        System.out.println("Movie:" + movie);
        session.getTransaction().commit();
    }

    // Finding all movies
    private void findAll() {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        List<Movie> movies = session.createQuery("from Movie").list();
        session.getTransaction().commit();
        System.out.println("All Movies:" + movies);
    }

    public static void main(String[] args) {
        BasicMovieManager movieManager = new BasicMovieManager();

        Movie topGun = new Movie();
        topGun.setTitle("Top Gun");
        topGun.setDirector("Tony Scott");
        topGun.setSynopsis("When Maverick encounters a pair of MiGs...");

        Movie jaws = new Movie();
        jaws.setTitle("Jaws");
        jaws.setDirector("Steven Spielberg");
        jaws.setSynopsis("A tale of a white shark!");

        movieManager.persistMovie(topGun);
        movieManager.persistMovie(jaws);
        movieManager.findAll();
    }
}
