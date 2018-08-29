package com.example.blurryrobot.wificonnect.dagger.module;

import android.content.Context;

import com.example.blurryrobot.wificonnect.App;
import com.nigelbrown.fluxion.Flux;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
@Singleton
public class ApplicationModule {
    private final App mApplication;

    public ApplicationModule(App application) {
        this.mApplication = application;
    }

    @Provides
    @Singleton
    public App provideApp() {
        return mApplication;
    }

    @Provides
    @Singleton
    public Context provideApplicationContext() {
        return this.mApplication;
    }

    @Singleton
    @Provides
    public Flux providesRxFLux(App app) {
        return Flux.init(app);
    }
}
