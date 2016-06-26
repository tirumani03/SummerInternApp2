package com.example.saratchandra.summerinternapp;

import android.annotation.TargetApi;
import android.app.usage.ConfigurationStats;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by SaratChandra on 5/25/2016.
 */
public class Login extends AppCompatActivity implements View.OnClickListener {
    EditText  username,pass;
    Button log,clr;
    TextView access;
    SharedPreferences credentials;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setTitle("Login");

        try {
            credentials = getApplicationContext().getSharedPreferences("cred", 0);
            String user = credentials.getString("name", "Unknown data");
            String secret = credentials.getString("password", "Unknown data");
            if (user.equals("root") && secret.equals("root")) {
                Intent allow = new Intent(getApplicationContext(), Home.class);
                allow.putExtra("uname",user);
                startActivity(allow);
                finish();
            } else if (user.equals("administrator") && secret.equals("admin")) {
                Intent allow = new Intent(getApplicationContext(), Home.class);
                allow.putExtra("uname",user);
                startActivity(allow);
                finish();
            }
        }catch (Exception e){
            e.printStackTrace();
            setReferences();
            log.setOnClickListener(this);
            clr.setOnClickListener(this);

        }
        setReferences();
        log.setOnClickListener(this);
        clr.setOnClickListener(this);


    }
    public void setReferences(){
        username =(EditText)findViewById(R.id.un);
        pass=(EditText)findViewById(R.id.pwd);
        log=(Button)findViewById(R.id.enter);
        clr=(Button)findViewById(R.id.clear);
        access=(TextView)findViewById(R.id.permission);

    }
    @Override
    public void onClick(View v ) {
          Intent i;
        switch (v.getId()) {
            case R.id.enter:
                if (username.getText().toString().isEmpty() || pass.getText().toString().isEmpty())
                { access.setText("Username or Password field is empty");
                    username.setText(""); pass.setText("");}
                else if (username.getText().toString().equals("root") && pass.getText().toString().equals("root")){
                    Toast.makeText(getApplicationContext(),"welcome "+username.getText().toString(),Toast.LENGTH_SHORT).show();
                     i= new Intent(this,Home.class);
                    i.putExtra("uname",username.getText().toString());
                    credentials = getApplicationContext().getSharedPreferences("cred", 0);
                    SharedPreferences.Editor edit = credentials.edit();
                    edit.putString("name",username.getText().toString());
                    edit.putString("password",pass.getText().toString());
                    edit.commit();
                    startActivity(i);
                    finish();

                }
                else if (username.getText().toString().equals("administrator") && pass.getText().toString().equals("admin")){
                      i=new Intent(this,Home.class);
                    i.putExtra("uname",username.getText().toString());
                    credentials = getApplicationContext().getSharedPreferences("cred", 0);
                    SharedPreferences.Editor edit = credentials.edit();
                    edit.putString("name",username.getText().toString());
                    edit.putString("password",pass.getText().toString());
                    edit.commit();
                    startActivity(i);
                    finish();
                   }
                else
                    access.setText("Access Denied");
                break;
            case R.id.clear:
             access.setText("");
                username.setText("");
                pass.setText("");
                break;

        }
    }

}
