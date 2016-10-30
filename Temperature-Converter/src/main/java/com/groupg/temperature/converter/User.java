/*
 * Copyright 2016 Niall Quinn.
 */
package com.groupg.temperature.converter;

import java.io.Serializable;
import java.util.UUID;

/**
 *
 * @author Niall Quinn
 */
public class User implements Serializable {

    String firstName;
    String lastName;
    UUID id;
    
    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = UUID.randomUUID();
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public UUID getId() {
        return id;
    }
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return new StringBuffer(" FirstName : ")
                .append(this.firstName)
                .append(" LastName : ")
                .append(this.lastName)
                .append(" Identifier : ")
                .append(this.id.toString())
                .toString();
    }

}
