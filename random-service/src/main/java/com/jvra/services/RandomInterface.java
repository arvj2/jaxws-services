package com.jvra.services;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * Created by Jansel R. Abreu (Vanwolf) on 10/20/2014.
 */

@WebService
public abstract interface RandomInterface {

    @WebMethod
    public abstract int next();

    @WebMethod
    public abstract int[] nextBulk( final int m );
 }
