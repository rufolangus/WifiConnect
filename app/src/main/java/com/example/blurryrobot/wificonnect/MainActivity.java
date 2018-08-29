package com.example.blurryrobot.wificonnect;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.nigelbrown.fluxion.Annotation.React;
import com.nigelbrown.fluxion.Reaction;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;


import static com.example.blurryrobot.wificonnect.Reactions.SHOW_CONNECTED;
import static com.example.blurryrobot.wificonnect.Reactions.SHOW_DISCONNECTED;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.wifi_button) Button button;
    @Inject ActionCreator actionCreator;
    @Inject WifiStore wifiStore;
    private Boolean connected = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        App.getInstance().getComponent().inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        actionCreator.disconnect();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (connected)
                    actionCreator.disconnect();
                else
                    actionCreator.connect();
            }
        });

    }

    @React(reactionType = SHOW_CONNECTED)
    public void ShowConnected(Reaction reaction)
    {
        connected = true;
        button.setText("Disconnect");
        Log.d("VIEW", "Connected");

    }

    @React(reactionType = SHOW_DISCONNECTED)
    public void ShowDisconnected(Reaction reaction)
    {
        connected = false;
        button.setText("Connect");
        Log.d("VIEW", "Disconnected");

    }
}
