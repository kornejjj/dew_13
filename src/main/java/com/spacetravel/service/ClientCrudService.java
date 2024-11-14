package com.spacetravel.service;

import com.spacetravel.entity.Client;
import com.spacetravel.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.List;
import java.util.Set;

public class ClientCrudService {

    private final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    private final Validator validator;


    public ClientCrudService() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        this.validator = factory.getValidator();
    }

    public void createClient(Client client) {

        validateClient(client);

        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(client);
            transaction.commit();
        }
    }

    public void updateClient(Client client) {

        validateClient(client);

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


    private void validateClient(Client client) {
        Set<ConstraintViolation<Client>> violations = validator.validate(client);
        if (!violations.isEmpty()) {
            StringBuilder errors = new StringBuilder("Validation failed: ");
            for (ConstraintViolation<Client> violation : violations) {
                errors.append(violation.getMessage()).append("; ");
            }
            throw new IllegalArgumentException(errors.toString());
        }
    }
}
