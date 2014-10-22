package com.auth.truststore;

import com.sun.net.httpserver.HttpsConfigurator;
import com.sun.net.httpserver.HttpsParameters;
import com.sun.net.httpserver.HttpsServer;
import sun.net.httpserver.HttpsServerImpl;

import javax.net.ssl.*;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.security.KeyStore;
import java.security.SecureRandom;

/**
 * Created by Jansel R. Abreu (Vanwolf) on 10/22/2014.
 */
public class HttpsPublisher {
    private static final int DEFAULT_PORT = 3443;
    private static final int BACKLOG = 12;
        private static final String KEYSTORE = "server.jks";

    private IService service;

    public static void main(String... args) throws Exception {
        new HttpsPublisher().init(TestService.class.getName(),"/test");
    }


    public void init(String name,String uri){
        try{
            Class<?> type = Class.forName(name);
            service= (IService)  type.newInstance();
        }catch (Exception ex){
            ex.printStackTrace();
        }

        HttpsServer server = getHttpsServer(uri,DEFAULT_PORT );
        if( null !=server ){
            server.createContext(uri);
            System.out.println("Listening on port "+DEFAULT_PORT+"...");
            server.start();
        }
    }

    private HttpsServer getHttpsServer(String uri, int port ){
        HttpsServer server = null;
        try{
            InetSocketAddress addrs = new InetSocketAddress(port);
            server = HttpsServer.create(addrs,BACKLOG);

            SSLContext context = SSLContext.getInstance("TLS");
            char[] pass = "123456".toCharArray();

            KeyStore store = KeyStore.getInstance("JKS");
            InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream(KEYSTORE);

            store.load(in,pass);

            KeyManagerFactory kmf = KeyManagerFactory.getInstance("SunX509");
            kmf.init(store,pass);


            TrustManagerFactory tmf = TrustManagerFactory.getInstance("SunX509");
            tmf.init(store);

            context.init(kmf.getKeyManagers(),tmf.getTrustManagers(),new SecureRandom() );

            final SSLEngine engine = context.createSSLEngine();
            server.setHttpsConfigurator( new HttpsConfigurator(context){
                @Override
                public void configure(HttpsParameters httpsParameters) {
                    httpsParameters.setCipherSuites(engine.getEnabledCipherSuites());
                    httpsParameters.setProtocols(engine.getEnabledProtocols());
                }
            });

            server.setExecutor(null);
            server.createContext(uri,new SelfHttpHandler(this.service));
        }catch ( Exception ex ){
            ex.printStackTrace();
        }
        return server;
    }
}
