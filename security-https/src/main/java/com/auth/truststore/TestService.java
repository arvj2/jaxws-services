package com.auth.truststore;

import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by Jansel R. Abreu (Vanwolf) on 10/22/2014.
 */
public class TestService implements IService{
    @Override
    public void doGet(HttpExchange exchange) {
        respondToClient(exchange,"doGet");
    }

    @Override
    public void doPost(HttpExchange exchange) {
        respondToClient(exchange,"doPost");
    }

    @Override
    public void doPut(HttpExchange exchange) {
        respondToClient(exchange,"doPut");
    }

    @Override
    public void doDelete(HttpExchange exchange) {
        respondToClient(exchange,"doDelete");
    }

    private void respondToClient(HttpExchange exchange,String response ){
        try {
            exchange.sendResponseHeaders(200, 0);
            OutputStream out = exchange.getResponseBody();
            out.write(response.getBytes());
            out.close();
        }catch ( IOException ex) {
            ex.printStackTrace();
        }
    }
}
