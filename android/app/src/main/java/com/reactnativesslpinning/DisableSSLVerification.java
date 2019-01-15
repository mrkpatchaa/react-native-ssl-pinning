package com.reactnativesslpinning;

import com.facebook.react.modules.network.OkHttpClientFactory;
import okhttp3.OkHttpClient;

public class DisableSSLVerification implements OkHttpClientFactory {

    @Override
    public OkHttpClient createNewNetworkModuleClient() {
        try {
            OkHttpUtil.init(true);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return OkHttpUtil.getClient();
    }
}