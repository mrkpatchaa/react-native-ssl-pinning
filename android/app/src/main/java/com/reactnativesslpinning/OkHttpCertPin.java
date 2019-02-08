package com.reactnativesslpinning;

import com.datatheorem.android.trustkit.TrustKit;
import com.datatheorem.android.trustkit.config.DomainPinningPolicy;
import com.datatheorem.android.trustkit.config.PublicKeyPin;
import com.facebook.react.modules.network.OkHttpClientFactory;
import com.facebook.react.modules.network.OkHttpClientProvider;
import com.facebook.react.modules.network.ReactCookieJarContainer;

import java.util.concurrent.TimeUnit;

import okhttp3.CertificatePinner;
import okhttp3.OkHttpClient;

public class OkHttpCertPin implements OkHttpClientFactory {

    @Override
    public OkHttpClient createNewNetworkModuleClient() {

        CertificatePinner.Builder certificatePinnerBuilder = new CertificatePinner.Builder();

        for (DomainPinningPolicy domainPinningPolicy : TrustKit.getInstance().getConfiguration().getAllPolicies()) {
            for (PublicKeyPin key : domainPinningPolicy.getPublicKeyPins()) {
                certificatePinnerBuilder.add(domainPinningPolicy.getHostname(), "sha256/" + key.toString());
            }
        }

        OkHttpClient.Builder client = new OkHttpClient.Builder().connectTimeout(0, TimeUnit.MILLISECONDS)
                .readTimeout(0, TimeUnit.MILLISECONDS).writeTimeout(0, TimeUnit.MILLISECONDS)
                .cookieJar(new ReactCookieJarContainer()).certificatePinner(certificatePinnerBuilder.build());
        return OkHttpClientProvider.enableTls12OnPreLollipop(client).build();
    }
}
