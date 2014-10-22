package jvra.com.service;

import jvra.com.types.ClientType;

import javax.jws.WebService;

/**
 * Created by Jansel R. Abreu (Vanwolf) on 10/21/2014.
 */

@WebService(endpointInterface = "jvra.com.service.Bank")
public class BankService implements Bank{
    @Override
    public boolean userHasAccount(ClientType client) {
        return false;
    }
}
