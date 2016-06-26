package com.example.saratchandra.summerinternapp;

import android.app.Activity;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v4.app.NotificationCompat;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by SaratChandra on 6/10/2016.
 */
public class NotificationTime extends Activity {
    NotificationCompat.Builder notification;
    private static final int uniqueId = 46466;
    Button notify;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notificationtime);
        Toast.makeText(this,"hello",Toast.LENGTH_SHORT).show();
        notification=new NotificationCompat.Builder(this);
        notification.setAutoCancel(true);
        notify=(Button)findViewById(R.id.notify);
        notify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                notification.setContentTitle("SummerInternApp");
                notification.setSmallIcon(R.mipmap.mylogo);
                notification.setTicker("Ticker");
                notification.setWhen(System.currentTimeMillis());
                notification.setContentText("Click me");
               // notification.setDefaults(NotificationCompat.DEFAULT_SOUND);
                notification.setDefaults(NotificationCompat.DEFAULT_ALL);
                Intent not=new Intent(getApplicationContext(),NotificationTime.class);
                PendingIntent pinot=PendingIntent.getActivity(getApplicationContext(),0,not,PendingIntent.FLAG_UPDATE_CURRENT);
                notification.setContentIntent(pinot);

                NotificationManager nm=(NotificationManager)getSystemService(NOTIFICATION_SERVICE);
                nm.notify(uniqueId,notification.build());
            }
        });
    }
}
