package com.spacetravel.service;

import com.spacetravel.entity.Planet;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import com.spacetravel.util.HibernateUtil;
import org.hibernate.SessionFactory;

import java.util.List;

public class PlanetCrudService {

    private final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    public void createPlanet(Planet planet) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.save(planet);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback(); // Виконуємо rollback у разі помилки
            }
            e.printStackTrace(); // Виводимо помилку для подальшого аналізу
        }
    }

    public void updatePlanet(Planet planet) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.update(planet);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public Planet getPlanet(String id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Planet.class, id);
        }
    }

    public void deletePlanet(String id) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            Planet planet = session.get(Planet.class, id);
            if (planet != null) {
                session.delete(planet);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public List<Planet> getAllPlanets() {
        try (Session session = sessionFactory.openSession()) {
            Query<Planet> query = session.createQuery("from Planet", Planet.class);
            return query.list();
        }
    }
}
