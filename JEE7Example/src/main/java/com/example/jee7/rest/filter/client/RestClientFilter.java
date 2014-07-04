package com.example.jee7.rest.filter.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Response;

/**
 *
 * @author David EXCOFFIER <david.excoffier@st.com>
 */
public class RestClientFilter {

    public void simpleGet() {
        Client client = ClientBuilder.newClient();
        Response response = client.target("http://127.0.0.1:8080/JEE7Example/rest/path/string")
                .register(ClientFilter.class) // <--------------------
                .request()
                .get();
        if (response.getStatus() == Response.Status.OK.getStatusCode()) {
            System.out.println(response.getEntity());
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

    }

}
