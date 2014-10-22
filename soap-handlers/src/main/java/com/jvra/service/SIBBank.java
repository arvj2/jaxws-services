package com.jvra.service;

import javax.jws.HandlerChain;
import javax.jws.WebService;

/**
 * Created by Jansel R. Abreu (Vanwolf) on 10/21/2014.
 */
@WebService( endpointInterface = "com.jvra.service.Bank" )
@HandlerChain(file = "SIBBankService_handler.xml")
public class SIBBank implements  Bank{
    @Override
    public boolean userHasAccount(ClientType client) {
        return false;
    }
}
