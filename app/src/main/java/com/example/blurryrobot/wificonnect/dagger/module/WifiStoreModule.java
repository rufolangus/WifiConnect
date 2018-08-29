package com.example.blurryrobot.wificonnect.dagger.module;

import com.example.blurryrobot.wificonnect.WifiStore;
import com.nigelbrown.fluxion.Flux;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
@Singleton
public class WifiStoreModule {
    @Provides
    @Singleton
    WifiStore providesWifiStore(Flux flux) {
        return new WifiStore(flux);
    }
}
