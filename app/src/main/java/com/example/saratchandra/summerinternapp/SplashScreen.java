package com.example.saratchandra.summerinternapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by SaratChandra on 5/29/2016.
 */
public class SplashScreen extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent i= new Intent(getApplicationContext(),All.class);
           startActivity(i);
           finish();
    }
}
