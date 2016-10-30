/*
 * Copyright 2016 Niall Quinn.
 */
package com.groupg.temperature.converter;

/**
 *
 * @author Niall Quinn
 */
import java.util.Random;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

@Path("/ranString")
public class RandomStringService {

    @GET
    @Path("/{param}")
    public Response returnRandomString(@PathParam("param") String message) {
        if (message.length() == 0) {
            return Response.status(500).entity("Invalid Param: Input is length 0").build();
        }
        try {
            int inputLength = Integer.parseInt(message);
            if (inputLength < 1) {
                return Response.status(500).entity("Invalid Param: Input is not a number").build();
            }
            String res = randomStringOfLength(inputLength);
            return Response.status(200).entity(res).build();
        } catch (NumberFormatException e) {
            return Response.status(500).entity("Invalid Param: Error when parsing number: " + e.getLocalizedMessage()).build();
        }
    }

    private String randomStringOfLength(int length) {
        char[] chars = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        StringBuilder sb = new StringBuilder();
        Random rand = new Random();
        for (int i = 0; i < length; i++) {
            char c = chars[rand.nextInt(chars.length)];
            sb.append(c);
        }
        return sb.toString();
    }
}
