package com.spacetravel.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;

@Entity
public class Planet {

    @Id
    private String id;

    @Column(name = "name", columnDefinition = "VARCHAR(255)")  // Замінили CHARACTER VARYING на VARCHAR
    private String name;

    // Геттери та сеттери
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
