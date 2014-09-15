package com.example.jee7.rest;

import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Cookie;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

/**
 *
 * @author David EXCOFFIER
 */
@Path("/path")
public class RestServer {

    @Context
    private UriInfo context;

    /*
     * GET simple
     */
    @GET
    @Path("/string")
    @Produces(MediaType.APPLICATION_JSON)
    public String getString() {
        return "MyString";
    }

    /*
     * Path param with default
     */
    @GET
    @Path("/stringPathParam/{username}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getStringPathParam(@PathParam("username") String userName) {
        return "MyString : " + userName;
    }

    /*
     * Path param with default By default, the URI variable must match the regular expression "[^/]+?". 
     * This variable may be customized by specifying a different regular expression after the variable name.
     */
    @GET
    @Path("/stringPathParamRegExp/{username: [a-zA-Z][a-zA-Z_0-9]*}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getStringPathParamRegExp(@PathParam("username") String userName) {
        return "MyString : " + userName;
    }

    /*
     * Path param with Pojo param with :
     * Any class with a constructor that accepts a single String argument.
     * Any class with the static method named valueOf(String) that accepts a single String argument.
     */
    @GET
    @Path("/stringPathParamPojo/{username}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getStringPathParam(@DefaultValue("toi") @PathParam("username") Week userName) {
        return "MyString : " + userName;
    }

    /*
     * Query param with Pojo param with 
     */
    @GET
    @Path("/stringQueryParam")
    @Produces(MediaType.APPLICATION_JSON)
    public String getStringQueryParam(@DefaultValue("toi") @QueryParam("username") String userName) {
        return "MyString : " + userName;
    }

    @GET
    @Path("/string5")
    public String getContext(@Context HttpHeaders hh) {
        MultivaluedMap<String, String> headerParams = hh.getRequestHeaders();
        Map<String, Cookie> pathParams = hh.getCookies();
        return "MyString : ";
    }

    @PUT
    @Path("/put/pojo")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response putPojo(MyPojo pojo) {
        System.out.println("PUT action  on " + pojo.getCode());
        return Response.ok().build();
    }

    @GET
    @Path("/get/pojo")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public MyPojo getPojo(MyPojo pojo) {
        System.out.println("PUT action  on " + pojo.getCode());
        return pojo;
    }

    @POST
    @Path("/weeks3")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getWeeksParam(Week week) {
        System.out.println("Action on server side ! " + week);
        return Response.ok().build();
    }

    @DELETE
    @Path("/string/{code}")
    public Response deleteWeek(@PathParam("code") String code) {
        System.out.println("DELETE action " + code);
        return Response.ok().build();
    }

    @GET
    public void roast(@Suspended AsyncResponse ar, @DefaultValue("toi") @QueryParam("username") String username) {
        //heavy lifting
        Response response = Response.ok(username).build();
        ar.resume(response);
    }

}
