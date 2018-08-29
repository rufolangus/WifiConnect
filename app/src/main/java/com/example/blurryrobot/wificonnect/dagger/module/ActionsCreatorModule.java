package com.example.blurryrobot.wificonnect.dagger.module;

import com.example.blurryrobot.wificonnect.ActionCreator;
import com.nigelbrown.fluxion.Flux;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
@Singleton
public class ActionsCreatorModule {
    @Singleton
    @Provides
    public ActionCreator providesActionCreator(Flux flux) {
        return new ActionCreator(flux);
    }

}
