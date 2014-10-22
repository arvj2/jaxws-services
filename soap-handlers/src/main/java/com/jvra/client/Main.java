package com.jvra.client;

import com.jvra.client.handlers.BankHandlerResolver;
import com.jvra.service.Bank;
import com.jvra.service.BankService;
import com.jvra.service.ClientType;

/**
 * Created by Jansel R. Abreu (Vanwolf) on 10/21/2014.
 */
public class Main {

    public static void main(String...args){
        BankService service = new BankService();
        service.setHandlerResolver( new BankHandlerResolver() );
        Bank bank = service.getBankPort();

        ClientType client = new ClientType();
        client.setLast("Rodriguez");
        client.setName( "Jansel" );
        System.out.println( bank.userHasAccount(client) );
    }
}
