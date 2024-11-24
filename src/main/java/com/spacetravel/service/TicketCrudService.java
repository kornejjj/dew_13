package com.spacetravel.service;

import com.spacetravel.entity.Ticket;
import com.spacetravel.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;

public class TicketCrudService {

    private final Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

    public void createTicket(Ticket ticket) {
        validateTicket(ticket);
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(ticket);
            transaction.commit();
        }
    }

    public void updateTicket(Ticket ticket) {
        validateTicket(ticket);
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(ticket);
            transaction.commit();
        }
    }

    public Ticket getTicket(Long id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Ticket.class, id);
        }
    }

    public void deleteTicket(Long id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            Ticket ticket = session.get(Ticket.class, id);
            if (ticket != null) {
                session.delete(ticket);
            }
            transaction.commit();
        }
    }

    public List<Ticket> getAllTickets() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Ticket", Ticket.class).list();
        }
    }

    private void validateTicket(Ticket ticket) {
        Set<ConstraintViolation<Ticket>> violations = validator.validate(ticket);
        if (!violations.isEmpty()) {
            throw new IllegalArgumentException("Ticket validation failed: " + violations);
        }
    }
}
