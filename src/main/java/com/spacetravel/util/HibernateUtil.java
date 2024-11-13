package com.spacetravel.util;

import com.spacetravel.entity.Client;
import com.spacetravel.entity.Planet;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private static SessionFactory sessionFactory;

    static {
        try {
            sessionFactory = new Configuration()
                    .configure("hibernate.cfg.xml")  // Це може бути xml файл конфігурації
                    .addAnnotatedClass(Client.class)  // Додаємо сутності
                    .addAnnotatedClass(Planet.class)
                    .buildSessionFactory();
        } catch (Exception e) {
            e.printStackTrace();
            throw new ExceptionInInitializerError(e);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
