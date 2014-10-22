package com.jvra.client.handlers;

import javax.xml.ws.handler.Handler;
import javax.xml.ws.handler.HandlerResolver;
import javax.xml.ws.handler.PortInfo;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jansel R. Abreu (Vanwolf) on 10/21/2014.
 */
public class BankHandlerResolver implements HandlerResolver {
    @Override
    public List<Handler> getHandlerChain(PortInfo portInfo) {
        final String allowedPort = "BankPort";
        List<Handler> handlers = new ArrayList<Handler>();

        if (portInfo.getPortName().getLocalPart().equals(allowedPort)) {
            handlers.add(new BankSoapHandler1());
            handlers.add(new BankSoapHandler2());
        }
        return handlers;
    }
}
