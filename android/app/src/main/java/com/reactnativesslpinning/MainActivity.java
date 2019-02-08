package com.reactnativesslpinning;

import android.os.Bundle;

import com.datatheorem.android.trustkit.TrustKit;
import com.facebook.react.ReactActivity;
import com.facebook.react.modules.network.OkHttpClientProvider;

public class MainActivity extends ReactActivity {

    /**
     * Returns the name of the main component registered from JavaScript. This is
     * used to schedule rendering of the component.
     */
    @Override
    protected String getMainComponentName() {
        return "ReactNativeSslPinning";
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        try {
            TrustKit.initializeWithNetworkSecurityConfiguration(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
        OkHttpClientProvider.setOkHttpClientFactory(new OkHttpCertPin());
        super.onCreate(savedInstanceState);
    }
}
