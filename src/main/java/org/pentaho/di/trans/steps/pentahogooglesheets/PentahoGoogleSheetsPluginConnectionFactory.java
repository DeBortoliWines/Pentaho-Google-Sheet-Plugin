package org.pentaho.di.trans.steps.pentahogooglesheets;

import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.security.GeneralSecurityException;

import java.net.Proxy;


public class PentahoGoogleSheetsPluginConnectionFactory {

    public static final String[] PROXY_TYPES = new String[] { "DIRECT", "HTTP", "SOCKS" };

    public static final String PROXY_TYPE_DIRECT = "DIRECT";
    public static final String PROXY_TYPE_HTTP = "HTTP";
    public static final String PROXY_TYPE_SOCKS = "SOCKS";

    static NetHttpTransport newProxyTransport(String proxyType, String proxyHost, int proxyPort) throws GeneralSecurityException, IOException {
        NetHttpTransport.Builder builder = new NetHttpTransport.Builder();
        builder.setProxy(new Proxy(Proxy.Type.valueOf(proxyType), new InetSocketAddress(proxyHost, proxyPort)));
        return builder.build();
    }

    public static NetHttpTransport newTransport(String proxyType, String proxyHost, String proxyPort) throws GeneralSecurityException, IOException, NumberFormatException {
        if (proxyType == null || proxyType.isEmpty()) proxyType = PROXY_TYPE_DIRECT;
        if ( !proxyType.equalsIgnoreCase(PROXY_TYPE_DIRECT) ) {
            Integer port = new Integer(proxyPort);
            return newProxyTransport(proxyType, proxyHost, port);
        } else {
            return GoogleNetHttpTransport.newTrustedTransport();
        }
    }

}
