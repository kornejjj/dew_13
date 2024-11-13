package com.spacetravel.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;

@Entity
public class Client {

    @Id
    private long id;

    @Column(name = "name", columnDefinition = "VARCHAR(255)")  // Замінили CHARACTER VARYING на VARCHAR
    private String name;

    // Геттери та сеттери
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
