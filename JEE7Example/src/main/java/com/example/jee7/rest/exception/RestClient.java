package com.example.jee7.rest.exception;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Response;

/**
 *
 * @author David EXCOFFIER <david.excoffier@st.com>
 */
public class RestClient {

    public static void getException() {
        Client client = ClientBuilder.newClient();
        Response response = client.target("http://127.0.0.1:8080/JEE7Example/rest/exception/string")
                .request()
                .get();
        System.out.println(response.getEntity());
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        getException();
    }

}
