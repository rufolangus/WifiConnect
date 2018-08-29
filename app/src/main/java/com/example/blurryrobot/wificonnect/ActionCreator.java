package com.example.blurryrobot.wificonnect;

import android.util.Log;

import com.nigelbrown.fluxion.Flux;
import com.nigelbrown.fluxion.FluxActionCreator;

import javax.inject.Inject;

public class ActionCreator extends FluxActionCreator implements Actions
{
    @Inject
    public ActionCreator(Flux flux)
    {
        super(flux);
    }

    @Override
    public void connect()
    {
        Log.d("Connect", "Con");
        emitAction(CONNECT_TO_WIFI);
    }

    @Override
    public void disconnect()
    {
        Log.d("Disc", "Disconnect");

        emitAction(DISCONNECT_FROM_WIFI);
    }

}
