package com.auth.truststore;

import javax.net.ssl.*;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.security.KeyStore;
import java.security.SecureRandom;

/**
 * Created by Jansel R. Abreu (Vanwolf) on 10/22/2014.
 */
public class HttpsClient {

    private static final String ENDPOINT = "https://localhost:3443/test";
    private static final String KEYSTORE = "client.jks";

    public static void main(String...args){
        new HttpsClient().runTests();
    }

    private void runTests(){
        try{
            SSLContext context = SSLContext.getInstance("TLS");
            char[] password = "123456".toCharArray();

            InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream(KEYSTORE);
            KeyStore store = KeyStore.getInstance("JKS");
            store.load(in,password);

            TrustManagerFactory fact = TrustManagerFactory.getInstance("SunX509");
            fact.init(store);

            context.init(null,fact.getTrustManagers(),new SecureRandom());
            HttpsURLConnection.setDefaultSSLSocketFactory(context.getSocketFactory());

            URL url = new URL(ENDPOINT);
            HttpsURLConnection con = getConnection(url,"GET");
            getTest(con);

        }catch( Exception ex) {
            ex.printStackTrace();
        }
    }

    private HttpsURLConnection getConnection(URL url,String verb ) throws IOException{
        HttpsURLConnection con = (HttpsURLConnection) url.openConnection();
        con.setDoInput(true);
        con.setDoOutput(true);
        con.setRequestMethod(verb);
        con.setHostnameVerifier(new HostnameVerifier() {
            @Override
            public boolean verify(String s, SSLSession sslSession) {
                return s.equals("localhost");
            }
        });

        return con;
    }

    private void getTest(HttpsURLConnection con){
        try{
            con.connect();
            readResponse("Response ",con);
            con.disconnect();
        }catch ( Exception ex) {
            ex.printStackTrace();
        }
    }

    private void readResponse(String msg, HttpsURLConnection conn) {
        try {
            byte[ ] buffer = new byte[512]; // plenty for testing
            InputStream in = conn.getInputStream();
            in.read(buffer);
            System.out.println(msg + new String(buffer));
        }
        catch(Exception e) { throw new RuntimeException(e); }
    }
}
