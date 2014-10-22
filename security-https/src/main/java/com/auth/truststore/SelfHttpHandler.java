package com.auth.truststore;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;

/**
 * Created by Jansel R. Abreu (Vanwolf) on 10/22/2014.
 */
public class SelfHttpHandler implements HttpHandler{
    private IService service;

    public SelfHttpHandler(IService service) {
        this.service = service;
    }

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        if( "GET".equals(exchange.getRequestMethod()) )
            service.doGet(exchange);
        if( "POST".equals(exchange.getRequestMethod()) )
            service.doPost(exchange);
        if( "PUT".equals(exchange.getRequestMethod()) )
            service.doPut(exchange);
        if( "DELETE".equals(exchange.getRequestMethod()) )
            service.doDelete(exchange);
    }
}
