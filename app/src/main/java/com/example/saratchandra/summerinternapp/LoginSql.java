package com.example.saratchandra.summerinternapp;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by SaratChandra on 6/9/2016.
 */
public class LoginSql extends Activity {
    EditText susername,spass;
    Button slog,sclr;
    TextView saccess;
    SharedPreferences scredentials;
   // UsersDatabaseHandler udb;
    CheckBox sremember;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginsql);
        setTitle("Login");
        setReferences();
        slog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
    public void setReferences(){
            susername =(EditText)findViewById(R.id.suser);
            spass=(EditText)findViewById(R.id.spwd);
            slog=(Button)findViewById(R.id.senter);
            sclr=(Button)findViewById(R.id.sclear);
            saccess=(TextView)findViewById(R.id.spermission);
            sremember=(CheckBox)findViewById(R.id.sremember);

    }
}
