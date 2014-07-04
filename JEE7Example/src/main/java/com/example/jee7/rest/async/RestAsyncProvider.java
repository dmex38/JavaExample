package com.example.jee7.rest.async;

import java.util.concurrent.TimeUnit;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

/**
 *
 * @author David EXCOFFIER
 */
//@Stateless
@Path("/path/async")
public class RestAsyncProvider {

    @Context
    private UriInfo context;

    /*
     * GET simple
     */
    @GET
    @Path("/string")
    @Produces(MediaType.APPLICATION_JSON)
    //@Asynchronous
    public void getString(@Suspended final AsyncResponse asyncResponse) throws InterruptedException {
        TimeUnit.SECONDS.sleep(20);
        asyncResponse.resume(Response.ok("MyString"));
    }

    /*
     * GET simple
     */
    @GET
    @Path("/string2")
    @Produces(MediaType.APPLICATION_JSON)
    public void getString2(@Suspended final AsyncResponse asyncResponse) throws InterruptedException {
        asyncResponse.setTimeoutHandler((hdl) -> {
            asyncResponse.resume(Response.status(Response.Status.SERVICE_UNAVAILABLE)
                    .entity("Operation time out.").build());

        });
        asyncResponse.setTimeout(50, TimeUnit.SECONDS);
        TimeUnit.SECONDS.sleep(20);
        asyncResponse.resume(Response.ok("MyString"));
    }
}
