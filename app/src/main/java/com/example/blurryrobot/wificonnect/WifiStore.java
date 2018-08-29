package com.example.blurryrobot.wificonnect;

import android.app.Application;
import android.content.Context;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiManager;
import android.util.Log;

import com.nigelbrown.fluxion.Annotation.Action;
import com.nigelbrown.fluxion.Annotation.Store;
import com.nigelbrown.fluxion.Flux;
import com.nigelbrown.fluxion.FluxAction;
import com.nigelbrown.fluxion.FluxStore;

import java.util.List;
import java.util.logging.Logger;

import javax.inject.Inject;

import static com.example.blurryrobot.wificonnect.Actions.CONNECT_TO_WIFI;
import static com.example.blurryrobot.wificonnect.Actions.DISCONNECT_FROM_WIFI;

import static com.example.blurryrobot.wificonnect.Reactions.SHOW_DISCONNECTED;
import static com.example.blurryrobot.wificonnect.Reactions.SHOW_CONNECTED;

@Store
public class WifiStore extends FluxStore {

    String ssid = "wifi";
    String psk = "12345678";
    @Inject
    WifiManager wifiManager;

    @Inject
    public WifiStore(Flux flux) {
        super(flux);
        registerActionSubscriber(this);
        wifiManager = (WifiManager) App.getInstance().getApplicationContext().getSystemService(Context.WIFI_SERVICE);
    }

    @Action(actionType = CONNECT_TO_WIFI)
    public void connectToWifi(FluxAction action) {
        try {
            WifiConfiguration conf = new WifiConfiguration();
            conf.SSID = "\"" + ssid + "\"";
            conf.preSharedKey = "\"" + psk + "\"";
            conf.status = WifiConfiguration.Status.ENABLED;
            conf.allowedProtocols.set(WifiConfiguration.Protocol.WPA);
            conf.allowedKeyManagement.set(WifiConfiguration.KeyMgmt.WPA_PSK);
            wifiManager.setWifiEnabled(true);
            int id = wifiManager.addNetwork(conf);
            if (id == -1)
                id = getExistingNetworkID(ssid);

            wifiManager.disconnect();
            wifiManager.enableNetwork(id, true);
            wifiManager.reconnect();
            emitReaction(SHOW_CONNECTED);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Action(actionType = DISCONNECT_FROM_WIFI)
    public void disconnectFromWifi(FluxAction action) {
        wifiManager.disconnect();
        emitReaction(SHOW_DISCONNECTED);
    }

    int getExistingNetworkID(String ssid) {
        List<WifiConfiguration> networks = wifiManager.getConfiguredNetworks();
        if (networks == null)
            return -1;
        for (WifiConfiguration existingConfig : networks)
            if (existingConfig.SSID.equals(ssid))
                return existingConfig.networkId;
        return -1;
    }

}
