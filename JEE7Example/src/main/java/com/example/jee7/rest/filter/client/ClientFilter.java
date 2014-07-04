package com.example.jee7.rest.filter.client;

import java.io.IOException;
import java.util.List;
import java.util.Map.Entry;
import javax.ws.rs.client.ClientRequestContext;
import javax.ws.rs.client.ClientRequestFilter;
import javax.ws.rs.client.ClientResponseContext;
import javax.ws.rs.client.ClientResponseFilter;
import javax.ws.rs.core.Response;

/**
 *
 * @author David EXCOFFIER david.excoffier@st.com
 */
public class ClientFilter implements ClientRequestFilter, ClientResponseFilter {

    @Override
    public void filter(ClientRequestContext requestContext) throws IOException {
        if (requestContext.getHeaders().get("Client-Name") == null) {
            requestContext.abortWith(
                    Response.status(Response.Status.BAD_REQUEST)
                    .entity("Client-Name header must be defined.")
                    .build());
        }
    }

    @Override
    public void filter(ClientRequestContext requestContext, ClientResponseContext responseContext) throws IOException {
        System.out.println("status: " + responseContext.getStatus());
        System.out.println("date: " + responseContext.getDate());
        System.out.println("last-modified: " + responseContext.getLastModified());
        System.out.println("location: " + responseContext.getLocation());
        System.out.println("headers:");
        for (Entry<String, List<String>> header : responseContext.getHeaders()
                .entrySet()) {
            System.out.print("\t" + header.getKey() + " :");
            for (String value : header.getValue()) {
                System.out.print(value + ", ");
            }
            System.out.print("\n");
        }
        System.out.println("media-type: " + responseContext.getMediaType().getType());
    }

}
