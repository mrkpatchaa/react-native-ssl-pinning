package com.reactnativesslpinning;

import com.facebook.react.modules.network.OkHttpClientFactory;
import com.facebook.react.modules.network.OkHttpClientProvider;
import com.datatheorem.android.trustkit.TrustKit;
import com.facebook.react.modules.network.ReactCookieJarContainer;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

import okhttp3.CertificatePinner;
import okhttp3.OkHttpClient;

public class OkHttpCertPinTrustKit implements OkHttpClientFactory {

    @Override
    public OkHttpClient createNewNetworkModuleClient() {
        String hostname;
        try {
            hostname = new URL("https://localhost:3000").getHost();
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return null;
        }

        OkHttpClient.Builder client = new OkHttpClient.Builder().connectTimeout(0, TimeUnit.MILLISECONDS)
                .readTimeout(0, TimeUnit.MILLISECONDS).writeTimeout(0, TimeUnit.MILLISECONDS)
                .cookieJar(new ReactCookieJarContainer())
                .sslSocketFactory(TrustKit.getInstance().getSSLSocketFactory(hostname),
                        TrustKit.getInstance().getTrustManager(hostname));
        return OkHttpClientProvider.enableTls12OnPreLollipop(client).build();
    }
}
