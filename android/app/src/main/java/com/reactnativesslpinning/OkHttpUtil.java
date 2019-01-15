package com.reactnativesslpinning;

import com.facebook.react.modules.network.OkHttpClientProvider;
import com.facebook.react.modules.network.ReactCookieJarContainer;

import okhttp3.*;

import javax.net.ssl.*;
import java.security.cert.CertificateException;
import java.util.concurrent.TimeUnit;

/*
More info
okhttp version used 3.8.1
https://gist.github.com/preethamhegdes/fcab7bced52bf2520994ce232f2102ed
https://gist.github.com/chalup/8706740
https://www.stubbornjava.com/posts/okhttpclient-trust-all-ssl-certificates
https://stackoverflow.com/questions/25509296/trusting-all-certificates-with-okhttp
*/
public class OkHttpUtil {

    private static OkHttpClient client = null;

    public static OkHttpClient getClient() {
        return client;
    }

    public static void init(boolean ignoreCertificate) throws Exception {

        OkHttpClient.Builder builder = new OkHttpClient.Builder();

        System.out.println("Initialising httpUtil with default configuration");
        if (ignoreCertificate) {
            builder = configureToIgnoreCertificate(builder);
        }

        // Other application specific configuration
        builder.connectTimeout(0, TimeUnit.MILLISECONDS).readTimeout(0, TimeUnit.MILLISECONDS)
                .writeTimeout(0, TimeUnit.MILLISECONDS).cookieJar(new ReactCookieJarContainer());

        client = OkHttpClientProvider.enableTls12OnPreLollipop(builder).build();
    }

    // Setting testMode configuration. If set as testMode, the connection will skip
    // certification check
    private static OkHttpClient.Builder configureToIgnoreCertificate(OkHttpClient.Builder builder) {
        System.out.println("Ignore Ssl Certificate");
        try {

            // Create a trust manager that does not validate certificate chains
            final TrustManager[] trustAllCerts = new TrustManager[] { new X509TrustManager() {
                @Override
                public void checkClientTrusted(java.security.cert.X509Certificate[] chain, String authType)
                        throws CertificateException {
                }

                @Override
                public void checkServerTrusted(java.security.cert.X509Certificate[] chain, String authType)
                        throws CertificateException {
                }

                @Override
                public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                    return new java.security.cert.X509Certificate[] {};
                }
            } };

            // Install the all-trusting trust manager
            final SSLContext sslContext = SSLContext.getInstance("SSL");
            sslContext.init(null, trustAllCerts, new java.security.SecureRandom());
            // Create an ssl socket factory with our all-trusting manager
            final SSLSocketFactory sslSocketFactory = sslContext.getSocketFactory();

            builder.sslSocketFactory(sslSocketFactory, (X509TrustManager) trustAllCerts[0]);
            builder.hostnameVerifier(new HostnameVerifier() {
                @Override
                public boolean verify(String hostname, SSLSession session) {
                    return true;
                }
            });
        } catch (Exception e) {
            System.out.println("Exception while configuring IgnoreSslCertificate" + e);
        }
        return builder;
    }

}