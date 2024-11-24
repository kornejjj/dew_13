package com.spacetravel.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name = "tickets")
public final class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @NotNull(message = "Client cannot be null")
    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    @NotNull(message = "From planet cannot be null")
    @ManyToOne
    @JoinColumn(name = "from_planet_id", nullable = false)
    private Planet fromPlanet;

    @NotNull(message = "To planet cannot be null")
    @ManyToOne
    @JoinColumn(name = "to_planet_id", nullable = false)
    private Planet toPlanet;

    public Ticket() {
        this.createdAt = LocalDateTime.now(); // Призначення поточної дати та часу
    }

    public Ticket(Client client, Planet fromPlanet, Planet toPlanet) {
        if (client == null || fromPlanet == null || toPlanet == null) {
            throw new IllegalArgumentException("Client and planets cannot be null");
        }
        this.client = client;
        this.fromPlanet = fromPlanet;
        this.toPlanet = toPlanet;
        this.createdAt = LocalDateTime.now();
    }

    // Геттери та сеттери
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        if (client == null) {
            throw new IllegalArgumentException("Client cannot be null");
        }
        this.client = client;
    }

    public Planet getFromPlanet() {
        return fromPlanet;
    }

    public void setFromPlanet(Planet fromPlanet) {
        if (fromPlanet == null) {
            throw new IllegalArgumentException("From planet cannot be null");
        }
        this.fromPlanet = fromPlanet;
    }

    public Planet getToPlanet() {
        return toPlanet;
    }

    public void setToPlanet(Planet toPlanet) {
        if (toPlanet == null) {
            throw new IllegalArgumentException("To planet cannot be null");
        }
        this.toPlanet = toPlanet;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", createdAt=" + createdAt +
                ", client=" + (client != null ? client.getName() : "null") +
                ", fromPlanet=" + (fromPlanet != null ? fromPlanet.getName() : "null") +
                ", toPlanet=" + (toPlanet != null ? toPlanet.getName() : "null") +
                '}';
    }
}
