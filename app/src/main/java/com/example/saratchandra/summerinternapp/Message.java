package com.example.saratchandra.summerinternapp;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by SaratChandra on 6/1/2016.
 */
public class Message extends AppCompatActivity implements View.OnClickListener {
    Button sendmessage;
    EditText message;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.message);
        setTitle("Message");
        setReferences();
        sendmessage.setOnClickListener(this);
    }
    public void setReferences(){
        message=(EditText)findViewById(R.id.sms);
        sendmessage=(Button)findViewById(R.id.sendmessage);
    }

    @Override
    public void onClick(View v) {
        String tono= message.getText().toString();
        String mes="hello";
        Intent smsLauncher = new Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:"+tono));
        smsLauncher.putExtra("sms_body",mes);
        try{
            startActivity(smsLauncher);
        }catch(ActivityNotFoundException e){

        }

    }

}
