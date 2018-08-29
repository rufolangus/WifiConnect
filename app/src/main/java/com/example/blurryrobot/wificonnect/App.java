package com.example.blurryrobot.wificonnect;

import android.util.Log;

import com.example.blurryrobot.wificonnect.dagger.component.AppComponent;
import com.example.blurryrobot.wificonnect.dagger.component.DaggerAppComponent;
import com.example.blurryrobot.wificonnect.dagger.module.ActionsCreatorModule;
import com.example.blurryrobot.wificonnect.dagger.module.ApplicationModule;
import com.example.blurryrobot.wificonnect.dagger.module.WifiStoreModule;

public class App extends android.app.Application
{
    public static final String TAG = App.class.getSimpleName();
    private static App instance;
    private AppComponent component;
    public static synchronized App getInstance()
    {
        return instance;
    }

    @Override
    public void onCreate() throws SecurityException
    {
        super.onCreate();
        Log.d(TAG,"THis ran");
        instance = this;
        component = DaggerAppComponent.builder().applicationModule(new ApplicationModule(this)).actionsCreatorModule(new ActionsCreatorModule()).wifiStoreModule(new WifiStoreModule()).build();
    }

    public AppComponent getComponent()
    {
        return component;
    }
}
