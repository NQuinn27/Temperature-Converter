/*
 * Copyright 2016 Niall Quinn.
 */
package com.groupg.temperature.converter;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;

/**
 *
 * @author Niall Quinn
 */
public class UserStorage {

    private ArrayList<User> userList;
    private static final String USERS_FILE_NAME = "users.dat";

    public UserStorage() {
        userList = new ArrayList<User>();
        this.initialiseUsers();
    }

    public void addUser(String firstName, String lastName) {
        User u = new User(firstName, lastName);
        if (userList.isEmpty()) {
            initialiseUsers();
        }
        userList.add(u);
        saveUsers();
    }

    private void initialiseUsers() {
        try {
            //use buffering
            InputStream file = new FileInputStream(USERS_FILE_NAME);
            InputStream buffer = new BufferedInputStream(file);
            ObjectInput input = new ObjectInputStream(buffer);
            try {
                //deserialize the List
                userList = (ArrayList<User>) input.readObject();
                //display its data
                for (User u : userList) {
                    System.out.println("Recovered User: " + u);
                }
            } catch (IOException ex) {
                System.out.println("Exception: " + ex.getMessage());
            } finally {
                input.close();
            }
        } catch (ClassNotFoundException | IOException ex) {
            System.out.println("Exception: " + ex.getMessage());
        }
    }

    private void saveUsers() {
        if (userList.isEmpty()) {
            return;
        }
        try {
            //use buffering
            OutputStream file = new FileOutputStream(USERS_FILE_NAME);
            OutputStream buffer = new BufferedOutputStream(file);
            ObjectOutput output = new ObjectOutputStream(buffer);
            try {
                output.writeObject(userList);
            } finally {
                output.close();
            }
        } catch (IOException ex) {
            System.out.println("Cannot perform output." + ex.getLocalizedMessage());
        }
    }

    public String userList() {
        if (userList.isEmpty()) {
            return "No Users";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Users : {\n");
        for (User u : userList) {
            sb.append("\t{\n")
            .append("\t\tfirstName : " + u.getFirstName() + ",\n")
            .append("\t\tlastName : " + u.getLastName() + ",\n")
            .append("\t\tid : " + u.getId().toString() + "\n")
            .append("\t}\n");
        }
        sb.append("}");
        return sb.toString();
    }
}
