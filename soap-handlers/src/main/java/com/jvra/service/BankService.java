
package com.jvra.service;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.4-b01
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "BankService", targetNamespace = "http://com.jvra/service", wsdlLocation = "file:/D:/IdeaProjects/certifications/ocejwd/jaxws-services/soap-handlers/src/main/java/com/jvra/contract/service.wsdl")
public class BankService
    extends Service
{

    private final static URL BANKSERVICE_WSDL_LOCATION;
    private final static WebServiceException BANKSERVICE_EXCEPTION;
    private final static QName BANKSERVICE_QNAME = new QName("http://com.jvra/service", "BankService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("file:/D:/IdeaProjects/certifications/ocejwd/jaxws-services/soap-handlers/src/main/java/com/jvra/contract/service.wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        BANKSERVICE_WSDL_LOCATION = url;
        BANKSERVICE_EXCEPTION = e;
    }

    public BankService() {
        super(__getWsdlLocation(), BANKSERVICE_QNAME);
    }

    public BankService(URL wsdlLocation) {
        super(wsdlLocation, BANKSERVICE_QNAME);
    }

    public BankService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    /**
     * 
     * @return
     *     returns Bank
     */
    @WebEndpoint(name = "BankPort")
    public Bank getBankPort() {
        return super.getPort(new QName("http://com.jvra/service", "BankPort"), Bank.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns Bank
     */
    @WebEndpoint(name = "BankPort")
    public Bank getBankPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://com.jvra/service", "BankPort"), Bank.class, features);
    }

    private static URL __getWsdlLocation() {
        if (BANKSERVICE_EXCEPTION!= null) {
            throw BANKSERVICE_EXCEPTION;
        }
        return BANKSERVICE_WSDL_LOCATION;
    }

}