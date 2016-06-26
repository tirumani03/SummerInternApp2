package com.example.saratchandra.summerinternapp;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.widget.Toast;

/**
 * Created by SaratChandra on 6/20/2016.
 */
public class MyService extends Service {
    MediaPlayer mp;
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        Toast.makeText(getApplicationContext(),"service created",Toast.LENGTH_SHORT).show();

        super.onCreate();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
