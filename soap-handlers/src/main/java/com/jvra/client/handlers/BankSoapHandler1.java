package com.jvra.client.handlers;

import javax.xml.namespace.QName;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;
import java.util.Collections;
import java.util.Set;

/**
 * Created by Jansel R. Abreu (Vanwolf) on 10/21/2014.
 */
public class BankSoapHandler1 implements SOAPHandler<SOAPMessageContext>{

    private static final String TAG = BankSoapHandler1.class.getCanonicalName();
    @Override
    public Set<QName> getHeaders() {
        System.out.println(TAG+": getHeaders");
        return Collections.EMPTY_SET;
    }

    @Override
    public boolean handleMessage(SOAPMessageContext context) {

        Boolean outbound = (Boolean) context.get( MessageContext.MESSAGE_OUTBOUND_PROPERTY );
        System.out.println(TAG+": handleMessage: "+outbound);
        return true;
    }

    @Override
    public boolean handleFault(SOAPMessageContext context) {
        System.out.println(TAG+": handleFault");
        return true;
    }

    @Override
    public void close(MessageContext context) {
        System.out.println(TAG+": close");
    }
}
