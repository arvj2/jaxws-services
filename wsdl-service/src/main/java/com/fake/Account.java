package com.fake;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

/**
 * Created by Jansel R. Abreu (Vanwolf) on 10/20/2014.
 */

@WebService(targetNamespace = "http://com.claro/services/account", name = "Account")
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT, parameterStyle = SOAPBinding.ParameterStyle.BARE)
public abstract interface Account {

    @WebMethod
    public abstract boolean isOpened(@WebParam( name="name" ) String name );
}
