package com.spacetravel.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.validation.constraints.Pattern;

@Entity
public class Planet {

    @Id
    @Pattern(regexp = "^[A-Z0-9]+$", message = "ID must contain only uppercase Latin letters and digits")
    private String id;

    @Column(name = "name", columnDefinition = "VARCHAR(255)")  // Замінили CHARACTER VARYING на VARCHAR
    private String name;


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
