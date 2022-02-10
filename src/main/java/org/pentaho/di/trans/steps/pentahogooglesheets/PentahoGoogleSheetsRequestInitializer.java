package org.pentaho.di.trans.steps.pentahogooglesheets;

import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestInitializer;

import java.io.IOException;

public class PentahoGoogleSheetsRequestInitializer implements HttpRequestInitializer {
    final HttpRequestInitializer requestInitializer;

    public PentahoGoogleSheetsRequestInitializer(HttpRequestInitializer requestInitializer) {
        this.requestInitializer = requestInitializer;
    }


    @Override
    public void initialize(HttpRequest httpRequest) throws IOException {
        requestInitializer.initialize(httpRequest);
        httpRequest.setConnectTimeout(0);
        httpRequest.setReadTimeout(0);
    }
}
