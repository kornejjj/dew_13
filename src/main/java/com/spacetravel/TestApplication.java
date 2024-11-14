package com.spacetravel;

import com.spacetravel.entity.Client;
import com.spacetravel.entity.Planet;
import com.spacetravel.service.ClientCrudService;
import com.spacetravel.service.PlanetCrudService;

import java.util.List;

public class TestApplication {

    public static void main(String[] args) {

        ClientCrudService clientCrudService = new ClientCrudService();
        PlanetCrudService planetCrudService = new PlanetCrudService();

        try {

            Client client1 = new Client();
            client1.setName("John Doe");
            clientCrudService.createClient(client1);


            Planet planet1 = new Planet();
            planet1.setId("EARTH");
            planet1.setName("Earth");
            planetCrudService.createPlanet(planet1);


            List<Client> clients = clientCrudService.getAllClients();
            List<Planet> planets = planetCrudService.getAllPlanets();

            System.out.println("Clients:");
            clients.forEach(client -> System.out.println(client.getName()));

            System.out.println("Planets:");
            planets.forEach(planet -> System.out.println(planet.getName()));


            client1.setName("John Updated");
            clientCrudService.updateClient(client1);


            planet1.setName("Earth Updated");
            planetCrudService.updatePlanet(planet1);


            clientCrudService.deleteClient(client1.getId());
            planetCrudService.deletePlanet(planet1.getId());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
