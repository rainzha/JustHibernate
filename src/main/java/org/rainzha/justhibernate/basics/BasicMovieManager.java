package org.rainzha.justhibernate.basics;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.rainzha.justhibernate.domain.Movie;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class BasicMovieManager {
    private SessionFactory sessionFactory = null;

    public BasicMovieManager() {
        initSessionFactory();
    }

    // Creating SessionFactory using 5.1 version of Hibernate
    private void initSessionFactory() {
        sessionFactory = new Configuration().configure().buildSessionFactory();
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
        List movies = session.createQuery("from Movie").list();
        session.getTransaction().commit();
        System.out.println("All Movies:" + movies);
    }

    public static void main(String[] args) {
        BasicMovieManager movieManager = new BasicMovieManager();

        Movie topGun = new Movie();
        topGun.setTitle("Top Gun");
        topGun.setDirector("Tony Scott");
        topGun.setSynopsis("When Maverick encounters a pair of MiGs.");
        topGun.setCreateTime(LocalDateTime.now());

        Movie jaws = new Movie();
        jaws.setTitle("Jaws");
        jaws.setDirector("Steven Spielberg");
        jaws.setSynopsis("A tale of a white shark!");
        jaws.setCreateTime(LocalDateTime.now());

        movieManager.persistMovie(topGun);
        movieManager.persistMovie(jaws);
        movieManager.findAll();

        movieManager.sessionFactory.close();
    }
}
