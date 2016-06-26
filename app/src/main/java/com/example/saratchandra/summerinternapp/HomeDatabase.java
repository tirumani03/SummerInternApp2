package com.example.saratchandra.summerinternapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


/**
 * Created by SaratChandra on 5/25/2016.
 */
public class HomeDatabase extends AppCompatActivity implements View.OnClickListener {
    Button logout;
    SharedPreferences credcheck;
    String user,secret,check;
    int y;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_activity);
        setTitle("Home");
        logout=(Button)findViewById(R.id.logout);
        logout.setOnClickListener(this);
        credcheck = getApplicationContext().getSharedPreferences("cred", 0);
        user =credcheck.getString("name","Unknown data");
        secret =credcheck.getString("password","Unknown data");
        check = credcheck.getString("check","Unknown data");
       String uname = getIntent().getExtras().getString("uname");


        //  uname="welcome";
        if (uname != null) {
            TextView tv = (TextView) findViewById(R.id.welcome);
            tv.setText(uname);
        }


    }


    @Override
    public void onClick(View v) {
        credcheck = getApplicationContext().getSharedPreferences("cred", 0);
        SharedPreferences.Editor edit = credcheck.edit();
       edit.remove("name");
       edit.remove("password");
        edit.commit();
        Intent go=new Intent(getApplicationContext(),LoginDatabase.class);
        //check=getIntent().getExtras().getString("check");
        if(check.equals("1")) {
            go.putExtra("remuser", user);
            go.putExtra("rempass", secret);
            go.putExtra("remstat",check);
        }
        startActivity(go);
        finish();

    }
}
