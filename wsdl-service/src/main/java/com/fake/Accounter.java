package com.fake;

import javax.jws.WebService;

/**
 * Created by Jansel R. Abreu (Vanwolf) on 10/20/2014.
 */
@WebService(endpointInterface = "com.fake.Account", portName = "AccountPort", serviceName = "AccountService")
public class Accounter implements Account {
    @Override
    public boolean isOpened(String name) {
        return false;
    }
}
