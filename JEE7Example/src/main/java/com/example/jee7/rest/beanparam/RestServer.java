package com.example.jee7.rest.beanparam;

import javax.ws.rs.BeanParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author David EXCOFFIER
 */
@Path("/beanParam")
public class RestServer {

    /*
     * Path param with default
     */
    @GET
    @Path("/stringPathParam/{username}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getStringPathParam(@BeanParam BeanParam1 beanParam) {
        return "MyString : " + beanParam.getQueryParam();
    }

}
