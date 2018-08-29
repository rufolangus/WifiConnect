package com.example.blurryrobot.wificonnect.dagger.module;

import android.content.Context;

import com.example.blurryrobot.wificonnect.App;
import com.nigelbrown.fluxion.Flux;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
@Singleton
public class AppModule {
    private final App application;

    public AppModule(App application) {
        this.application = application;
    }

    @Provides
    @Singleton
    public App provideApp() {
        return application;
    }

    @Provides
    @Singleton
    public Context provideApplicationContext() {
        return this.application;
    }

    @Singleton
    @Provides
    public Flux providesRxFLux(App app) {
        return Flux.init(app);
    }
}
