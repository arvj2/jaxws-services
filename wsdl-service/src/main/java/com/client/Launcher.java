package com.client;


import jvra.com.service.BankService;

import javax.xml.ws.Endpoint;

/**
 * Created by Jansel R. Abreu (Vanwolf) on 10/20/2014.
 */
public class Launcher {

    public static void main(String... arg) {
        final String URL = "http://localhost:7979/bank";
        Endpoint.publish(URL, new BankService());
    }
}
