package com.spacetravel;

import com.spacetravel.entity.Client;
import com.spacetravel.entity.Planet;
import com.spacetravel.entity.Ticket;
import com.spacetravel.service.ClientCrudService;
import com.spacetravel.service.PlanetCrudService;
import com.spacetravel.service.TicketCrudService;

public class TestApplication {
    public static void main(String[] args) {
        ClientCrudService clientService = new ClientCrudService();
        PlanetCrudService planetService = new PlanetCrudService();
        TicketCrudService ticketService = new TicketCrudService();

        // Створення клієнта
        Client client = new Client();
        client.setName("Jane Doe");
        clientService.createClient(client);

        // Створення планет
        Planet earth = new Planet();
        earth.setId("EARTH");
        earth.setName("Earth");
        planetService.createPlanet(earth);

        Planet mars = new Planet();
        mars.setId("MARS");
        mars.setName("Mars");
        planetService.createPlanet(mars);

        // Створення квитка
        Ticket ticket = new Ticket();
        ticket.setClient(client);
        ticket.setFromPlanet(earth);
        ticket.setToPlanet(mars);

        ticketService.createTicket(ticket);

        // Перевірка роботи CRUD
        System.out.println("Tickets:");
        for (Ticket t : ticketService.getAllTickets()) {
            System.out.println("Ticket ID: " + t.getId() +
                    ", Client: " + t.getClient().getName() +
                    ", From: " + t.getFromPlanet().getName() +
                    ", To: " + t.getToPlanet().getName());
        }
    }
}
