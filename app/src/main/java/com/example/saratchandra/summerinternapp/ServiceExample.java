package com.example.saratchandra.summerinternapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by SaratChandra on 6/20/2016.
 */
public class ServiceExample extends AppCompatActivity implements View.OnClickListener{
    Button btnstart,btstop,btnNext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.serviceexample);
        btnstart=(Button)findViewById(R.id.btnstart);
        btstop=(Button)findViewById(R.id.btnstop);
        btnNext=(Button)findViewById(R.id.btnnext);
        btnstart.setOnClickListener(this);
        btnstart.setOnClickListener(this);
        btnstart.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btnstart:
                startService(new Intent(this,MyService.class));
                break;
            case R.id.btnstop:
                startService(new Intent(this,MyService.class));
                break;
            case R.id.btnnext:
                Intent iservice=new Intent(this,MainActivity.class);
                break;
        }
    }
}
