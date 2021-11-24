package org.pentaho.di.trans.steps.pentahogooglesheets;

import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.security.GeneralSecurityException;

import java.net.Proxy;


public class PentahoGoogleSheetsPluginConnectionFactory {

    static NetHttpTransport newProxyTransport(String proxyHost, int proxyPort) throws GeneralSecurityException, IOException {
        NetHttpTransport.Builder builder = new NetHttpTransport.Builder();
        builder.setProxy(new Proxy(Proxy.Type.HTTP, new InetSocketAddress(proxyHost, proxyPort)));
        return builder.build();
    }

    public static NetHttpTransport newTransport(String proxyHost, String proxyPort) throws GeneralSecurityException, IOException {
        if ( proxyHost != null && proxyPort != null ) {
            Integer port = new Integer(proxyPort);
            return newProxyTransport(proxyHost, port);
        } else {
            return GoogleNetHttpTransport.newTrustedTransport();
        }
    }

}
