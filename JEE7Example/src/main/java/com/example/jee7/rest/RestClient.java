package com.example.jee7.rest;

import java.net.URI;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

/**
 *
 * @author David EXCOFFIER <david.excoffier@st.com>
 */
public class RestClient {

    public void simpleGet() {

        URI uri1 = UriBuilder.fromUri("http://localhost/")
                .path("{a}")
                .queryParam("name", "{value}")
                .build("segment", "value");

        final URI uri2 = UriBuilder.fromUri("http://{host}/{path}?q={param}")
                .resolveTemplate("host", "localhost")
                .resolveTemplate("path", "myApp")
                .resolveTemplate("param", "value").build();

        Client client = ClientBuilder.newClient();
        Response response = client.target("http://127.0.0.1:8080/JEE7Example/rest/path/string").request().get();
        if (response.getStatus() == Response.Status.OK.getStatusCode()) {
            System.out.println(response.getEntity());
        }
    }

    public void getWithPathParam() {
        Client client = ClientBuilder.newClient();
        Response response = client.target("http://127.0.0.1:8080/JEE7Example/rest/path/stringPathParam")
                .path("toto")
                .request()
                .get();
        if (response.getStatus() == Response.Status.OK.getStatusCode()) {
            System.out.println(response.getEntity());
        }
    }

    public void getWithQueryParam() {
        Client client = ClientBuilder.newClient();
        Response response = client.target("http://127.0.0.1:8080/JEE7Example/rest/path/stringQueryParam")
                .request()
                .property("username", "titi")
                .get();
        if (response.getStatus() == Response.Status.OK.getStatusCode()) {
            System.out.println(response.getEntity());
        }
    }

    public void getWithGenericTypeResult() {
        Client client = ClientBuilder.newClient();
        Response response = client.target("http://127.0.0.1:8080/JEE7Example/rest/path/generictype")
                .request()
                .property("username", "titi")
                .get();
        if (response.getStatus() == Response.Status.OK.getStatusCode()) {
            Class<?> result = response.readEntity(new GenericType<Class<?>>() {
            });
            System.out.println(result);
        }
    }

    public void creatRequestAndReuse() {
        Client client = ClientBuilder.newClient();
        Invocation query = client.target("http://127.0.0.1:8080/JEE7Example/rest/path/generictype")
                .request()
                .property("username", "titi")
                .buildGet();
        Response response = query.invoke();
        if (response.getStatus() == Response.Status.OK.getStatusCode()) {
            Class<?> result = response.readEntity(new GenericType<Class<?>>() {
            });
            System.out.println(result);
        }
    }

    public static void putPojo() {
        Client client = ClientBuilder.newClient();
        Invocation query = client.target("http://127.0.0.1:8080/JEE7Example/rest/path/put/pojo")
                .request()
                .buildPut(Entity.json(new MyPojo("TITI", "TATA")));

        Response response = query.invoke();
        if (response.getStatus() == Response.Status.OK.getStatusCode()) {
            System.out.println(response.getStatus());
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        putPojo();
    }

}
