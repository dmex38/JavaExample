package com.example.jee7.rest.exception;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

/**
 *
 * @author David EXCOFFIER
 */
@Path("/exception")
public class RestServer {

    @Context
    private UriInfo context;

    /*
     * GET simple
     */
    @GET
    @Path("/string")
    @Produces(MediaType.APPLICATION_JSON)
    public String getException() {
        throw new OrderNotFoundException(5);
    }

}
