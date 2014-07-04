package com.example.jee7.rest.link;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author David EXCOFFIER david.excoffier@st.com
 */
@Path("/link")
public class RestLinkProvider {

    /*
     * GET simple
     */
    @GET
    @Path("/string")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getString() {
        return Response.ok()
                .entity("MyString")
                .link("parents", "http://oracle.co").build();
    }

}
