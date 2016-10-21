package com.groupg.temperature.converter;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;


/*
 * Copyright 2016 Niall Quinn.
 */
/**
 *
 * @author Niall Quinn
 */
@Path("/far2cel")

public class FarToCelService {

    @GET
    @Path("/{param}")
    @Produces(MediaType.TEXT_HTML)
    public Response convertFahrenheitToCelciusHTML(@PathParam("param") String message) {
        TemperatureConverter con = new TemperatureConverter();
        System.out.print("Here");
        Double val = Double.parseDouble(message);
        double res = con.convertFarToCel(val);
        String resString = String.format("%.2f", res);
        String output = "<html><body><h1>" + message + " fahrenheit is " + resString + " celcius</h1></body></html>";
        return Response.status(200).entity(output).build();
    }

    @GET
    @Path("/{param}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response convertFahrenheitToCelciusJSON(@PathParam("param") String message) {
        TemperatureConverter con = new TemperatureConverter();
        Double val = Double.parseDouble(message);
        double res = con.convertFarToCel(val);
        String resString = String.format("%.2f", res);

        try {
            JsonFactory factory = new JsonFactory();
            Writer writer = new StringWriter();
            JsonGenerator g = factory.createGenerator(writer);
            g.writeStartObject();                           //{
            g.writeObjectFieldStart("data");                //data : {
            g.writeStringField("inputValue", message);      //"inputValue" : inValue,
            g.writeStringField("inputUnit", "Fahrenheit");  //"inputUnit"  : "Fahrenheit",
            g.writeStringField("outputValue", resString);   //"outputValue": outValue,
            g.writeStringField("outputUnit", "Celcius");    //"outputUnit" : Celcius
            g.writeEndObject();                             // }
            g.close();                                      // }
            return Response.status(200).entity(writer.toString()).build();
        } catch (IOException e) {
            return Response.status(500).entity("Internal Server Error").build();
        }
    }
}
