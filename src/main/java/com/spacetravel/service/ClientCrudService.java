package com.spacetravel.service;

import com.spacetravel.entity.Client;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import com.spacetravel.util.HibernateUtil;
import org.hibernate.SessionFactory;

import java.util.List;

public class ClientCrudService {

    private final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    public void createClient(Client client) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(client);
            transaction.commit();
        }
    }

    public void updateClient(Client client) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(client);
            transaction.commit();
        }
    }

    public Client getClient(long id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Client.class, id);
        }
    }

    public void deleteClient(long id) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            Client client = session.get(Client.class, id);
            if (client != null) {
                session.delete(client);
            }
            transaction.commit();
        }
    }

    public List<Client> getAllClients() {
        try (Session session = sessionFactory.openSession()) {
            Query<Client> query = session.createQuery("from Client", Client.class);
            return query.list();
        }
    }
}
