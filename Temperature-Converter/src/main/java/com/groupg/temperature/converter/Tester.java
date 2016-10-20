/*
 * Copyright 2016 Niall Quinn.
 */
package com.groupg.temperature.converter;

/**
 *
 * @author Niall Quinn
 */
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

@Path("/hello")
public class Tester {

    @GET
    @Path("/{param}")
    public Response sayHelloWorld(@PathParam("param") String message) {
        String output = "Hello	" + message + "!";
        return Response.status(200).entity(output).build();
    }
}
