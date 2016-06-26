package com.example.saratchandra.summerinternapp;

import android.annotation.TargetApi;
import android.app.usage.ConfigurationStats;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

/**
 * Created by SaratChandra on 6/3/2016.
 */
public class UsageStats extends AppCompatActivity {
    ConfigurationStats usedstats;
    long s;
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.usagestats);
        if(Long.toString(s).equals(null))
          s= usedstats.getTotalTimeActive();

        Toast.makeText(getApplicationContext(),Long.toString(s),Toast.LENGTH_SHORT);

    }
}
