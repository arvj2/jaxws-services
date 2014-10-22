package com.auth.truststore;

import com.sun.net.httpserver.HttpExchange;

/**
 * Created by Jansel R. Abreu (Vanwolf) on 10/22/2014.
 */
public abstract interface IService {
    public abstract void doGet(HttpExchange exchange);
    public abstract void doPost(HttpExchange exchange);
    public abstract void doPut(HttpExchange exchange);
    public abstract void doDelete(HttpExchange exchange);
}
