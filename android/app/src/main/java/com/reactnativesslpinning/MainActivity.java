package com.reactnativesslpinning;

import android.os.Bundle;

import com.facebook.react.ReactActivity;
import com.facebook.react.modules.network.OkHttpClientProvider;
import com.reactnativesslpinning.OkHttpCertPin;

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
        super.onCreate(savedInstanceState);
        OkHttpClientProvider.setOkHttpClientFactory(new OkHttpCertPin());
    }
}
