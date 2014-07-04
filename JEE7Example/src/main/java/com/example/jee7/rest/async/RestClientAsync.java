package com.example.jee7.rest.async;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.InvocationCallback;
import javax.ws.rs.core.Response;

/**
 *
 * @author David EXCOFFIER <david.excoffier@st.com>
 */
public class RestClientAsync {

    public void simpleGet1() throws InterruptedException, ExecutionException {
        Client client = ClientBuilder.newClient();
        Future<Response> responseFuture = client.target("http://127.0.0.1:8080/JEE7Example/rest/path/async/string")
                .request()
                .async()
                .get();

        Response response = responseFuture.get();
        if (response.getStatus() == Response.Status.OK.getStatusCode()) {
            System.out.println(response.getEntity());
        }
    }

    public void simpleGet2() throws InterruptedException, ExecutionException {
        Client client = ClientBuilder.newClient();
        Future<Response> responseFuture = client.target("http://127.0.0.1:8080/JEE7Example/rest/path/async/string2")
                .request()
                .async()
                .get();
        Response response = responseFuture.get();
        if (response.getStatus() == Response.Status.OK.getStatusCode()) {
            System.out.println(response.getEntity());
        }
    }

    public void simpleGet3() throws InterruptedException, ExecutionException {
        Client client = ClientBuilder.newClient();
        Future<Response> responseFuture = client.target("http://127.0.0.1:8080/JEE7Example/rest/path/async/string2")
                .request()
                .async()
                .get(new InvocationCallback<Response>() {
                    @Override
                    public void completed(final Response result) {
                        System.out.println("Result: " + result);
                    }

                    @Override
                    public void failed(final Throwable throwable) {
                        throwable.printStackTrace();
                    }
                });
        Response response = responseFuture.get();
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
