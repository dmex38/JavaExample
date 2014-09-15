package com.example.jee7.rest.interceptor;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author David EXCOFFIER david.excoffier@st.com
 */
@Path("/interceptor")
//@Compress for all resources or on Application for all
public class RestServer {

    /*
     * GET simple
     */
    @GET
    @Compress // <--------------
    @Path("/string")
    @Produces(MediaType.APPLICATION_JSON)
    public String getString() {
        return "MyString";
    }

}
