package com.auth.google;

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;

import javax.net.ssl.*;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

/**
 * Created by Jansel R. Abreu (Vanwolf) on 10/22/2014.
 */
public class GoogleClient {

    public static void main(String... args) {
        final String endpoint = "https://www.google.com:443/";
        try {
            URL url = new URL(endpoint);

            SSLContext context = SSLContext.getInstance("TLS");
            TrustManager[] tm = getTrustManager();

            context.init(null,tm,new SecureRandom());
            HttpsURLConnection.setDefaultSSLSocketFactory( context.getSocketFactory() );

            HttpsURLConnection con = (HttpsURLConnection) url.openConnection();
            con.setDoInput(true);
            con.setRequestMethod("GET");
            con.connect();
            dumpDetail(con);

        } catch (MalformedURLException ex) {
            ex.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static void dumpDetail(HttpsURLConnection con) {
        try {
            System.out.println("CipherSuite=> " + con.getCipherSuite());
            System.out.println("ResponseCode=> " + con.getResponseCode());
            System.out.println("ResponseMessage=> " + con.getResponseMessage());

            Certificate[] certs = con.getServerCertificates();
            for (Certificate cert : certs) {

                System.out.println("*************************************************");

                System.out.println(Base64.encode(cert.getEncoded()));
                System.out.println(cert.getType());
                System.out.println(cert.hashCode());

                System.out.println("-------------------PUBLIC KEY--------------------");

                PublicKey key = cert.getPublicKey();
                System.out.println(key.getAlgorithm());
                System.out.println(key.getFormat());
                System.out.println(Base64.encode(key.getEncoded()));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


    private static TrustManager[] getTrustManager(){
        TrustManager[] trust = new TrustManager[]{
                new X509TrustManager() {
                    @Override
                    public void checkClientTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {
                    }

                    @Override
                    public void checkServerTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {
                    }

                    @Override
                    public X509Certificate[] getAcceptedIssuers() {
                        return null;
                    }
                }
        };
        return trust;
    }
}
