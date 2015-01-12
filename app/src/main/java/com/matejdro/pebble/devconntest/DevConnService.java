package com.matejdro.pebble.devconntest;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import org.java_websocket.client.WebSocketClient;

import java.net.URI;
import java.net.URISyntaxException;

/**
 * Created by Matej on 12.1.2015.
 */
public class DevConnService extends Service {
    private WebSocketClient client;

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        try {
            client = new DummyWebSocketClient(new URI("ws://127.0.0.1:9000"));
            client.connect();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onDestroy() {
        client.close();
    }
}
