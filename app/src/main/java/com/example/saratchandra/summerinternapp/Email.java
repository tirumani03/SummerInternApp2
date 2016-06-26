package com.example.saratchandra.summerinternapp;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by SaratChandra on 6/1/2016.
 */
public class Email extends AppCompatActivity implements View.OnClickListener {
    Button send;
    EditText email;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.email);
        setTitle("Email");
        setReferences();
        send.setOnClickListener(this);
    }
    public void setReferences(){
        email=(EditText)findViewById(R.id.recievers);
        send=(Button)findViewById(R.id.send);
    }

    @Override
    public void onClick(View v) {
        String[]to=email.getText().toString().split(";");
        Intent emailLauncher = new Intent(Intent.ACTION_SEND_MULTIPLE);
        emailLauncher.setType("message/rfc822");
        emailLauncher.putExtra(Intent.EXTRA_EMAIL, to);
        emailLauncher.putExtra(Intent.EXTRA_SUBJECT, "check this subject line");
        emailLauncher.putExtra(Intent.EXTRA_TEXT, "hey check this message body!");
        try{
            startActivity(emailLauncher);
        }catch(ActivityNotFoundException e){

        }

    }
}
