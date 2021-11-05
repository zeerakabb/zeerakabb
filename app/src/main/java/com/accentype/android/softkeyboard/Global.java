package com.accentype.android.softkeyboard;

import android.app.Application;

import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkConfiguration;

public class Global extends Application {

    public void setSet_Color(int set_Color)
    {
        Set_Color = set_Color;
    }

    public int getGet_Color()
    {
        return get_Color;
    }

    private int get_Color;
    private int Set_Color;

    @Override
    public void onCreate() {
        super.onCreate();
        AppLovinSdk.getInstance(this).setMediationProvider("max");
        AppLovinSdk.initializeSdk(this, new AppLovinSdk.SdkInitializationListener() {
            @Override
            public void onSdkInitialized(final AppLovinSdkConfiguration configuration) {
            }
        });
    }
}
