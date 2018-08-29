package com.example.blurryrobot.wificonnect;

public interface Actions
{
    String CONNECT_TO_WIFI = "connect";
    String DISCONNECT_FROM_WIFI = "disconnect";
    void connect();
    void disconnect();
}
