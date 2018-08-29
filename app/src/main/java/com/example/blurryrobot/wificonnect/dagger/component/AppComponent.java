package com.example.blurryrobot.wificonnect.dagger.component;

import com.example.blurryrobot.wificonnect.MainActivity;
import com.example.blurryrobot.wificonnect.WifiStore;
import com.example.blurryrobot.wificonnect.dagger.module.ActionsCreatorModule;
import com.example.blurryrobot.wificonnect.dagger.module.ApplicationModule;
import com.example.blurryrobot.wificonnect.dagger.module.WifiStoreModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ApplicationModule.class,WifiStoreModule.class,ActionsCreatorModule.class})
public interface AppComponent
{
    void inject(MainActivity mainActivity);
}
