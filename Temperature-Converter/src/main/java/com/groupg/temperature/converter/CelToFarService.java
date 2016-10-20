package com.groupg.temperature.converter;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
/*
 * Copyright 2016 Niall Quinn.
 */

/**
 *
 * @author Niall Quinn
 */
@Path("/cel2far")

public class CelToFarService {
    @GET
    @Path("/{param}")
    @Produces(MediaType.TEXT_HTML)
    public Response convertCelciusToFahrenheit(@PathParam("param") String message) {
        TemperatureConverter con = new TemperatureConverter();
        System.out.print("Here");
        Double val = Double.parseDouble(message);
        double res = con.convertCelToFar(val);
        String resString = String.format("%.2f", res);
        String output = "<html><body><h1>" + message + " celcius is " + resString + " fahrenheit</h1></body></html>";
        return Response.status(200).entity(output).build();
    }
}
