package com.reactnativesslpinning;

import com.facebook.react.modules.network.OkHttpClientFactory;
import com.facebook.react.modules.network.OkHttpClientProvider;
import com.facebook.react.modules.network.ReactCookieJarContainer;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import okhttp3.CertificatePinner;
import okhttp3.OkHttpClient;

public class OkHttpCertPin implements OkHttpClientFactory {

    @Override
    public OkHttpClient createNewNetworkModuleClient() {
        String hostname;
        try {
            hostname = new URL("https://localhost:3000").getHost();
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return null;
        }

        CertificatePinner certificatePinner = new CertificatePinner.Builder()
                .add(hostname, "sha256/miRL3esL3Vrr1eKLS1k57h1nZQ0HRGW05zhfUoccP78=")
                // .add(hostname, "sha256/YOUR_PUBLIC_KEY_HASH_BACKUP1")
                // .add(hostname, "sha256/YOUR_PUBLIC_KEY_HASH_BACKUP2")
                .build();

        OkHttpClient.Builder client = new OkHttpClient.Builder().connectTimeout(0, TimeUnit.MILLISECONDS)
                .readTimeout(0, TimeUnit.MILLISECONDS).writeTimeout(0, TimeUnit.MILLISECONDS)
                .cookieJar(new ReactCookieJarContainer()).certificatePinner(certificatePinner);
        return OkHttpClientProvider.enableTls12OnPreLollipop(client).build();
    }
}
