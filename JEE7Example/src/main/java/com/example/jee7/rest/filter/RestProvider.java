package com.example.jee7.rest.filter;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author David EXCOFFIER david.excoffier@st.com
 */
@Path("/filter")
//@Logged for all resources or on Application for all
public class RestProvider {

    /*
     * GET simple
     */
    @GET
    @Logged // <--------------
    @Path("/string")
    @Produces(MediaType.APPLICATION_JSON)
    public String getString() {
        return "MyString";
    }

}
