/*
 * Copyright 2016 Niall Quinn.
 */
package com.groupg.temperature.converter;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Niall Quinn
 */
@Path("/user")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UserService {

    //Add a user to the storage
    @POST
    @Path("add")
    public Response addUser(
            @QueryParam("firstName") String fName,
            @QueryParam("lastName") String lName) {

        if (fName == null || lName == null) {
            return Response
                .status(500)
                .entity("Invalid params. Example cURL: curl -X POST http://localhost:8080/api/user/add\\?firstName\\=Joe\\&lastName\\=Bloggs"
                       ).build();
        }
        UserStorage s = new UserStorage();
        s.addUser(fName, lName);
        return Response
                .status(200)
                .entity("User " + fName + " " + lName + " added."
                       ).build();

    }
    
    //List all users in the storage
    @GET
    @Path("list")
    public Response GetUserList(){
       UserStorage s = new UserStorage();
       return Response
                .status(200)
                .entity(s.userList()).build();
    }
}
