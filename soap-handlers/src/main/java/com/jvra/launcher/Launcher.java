package com.jvra.launcher;

import com.jvra.service.SIBBank;

import javax.xml.ws.Endpoint;

/**
 * Created by Jansel R. Abreu (Vanwolf) on 10/21/2014.
 */
public class Launcher {
    public static void main(String...args) {
        Endpoint.publish("http://localhost:7878/bank",new SIBBank() );
    }
}
