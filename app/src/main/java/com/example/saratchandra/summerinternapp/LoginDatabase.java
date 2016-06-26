package com.example.saratchandra.summerinternapp;

import android.annotation.TargetApi;
import android.app.usage.ConfigurationStats;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by SaratChandra on 5/25/2016.
 */
public class LoginDatabase extends AppCompatActivity implements View.OnClickListener {
    EditText  dusername,dpass;
    Button dlog,dclr;
    TextView daccess;
    SharedPreferences credentials;
    UsersDatabaseHandler udb;
    CheckBox dremember;
    String remus,rempa,remstatus;
    public static int prefill=0;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.logindatabase);
        setTitle("Login");
        setReferences();
          udb=new UsersDatabaseHandler(this);
        try {
             remus = getIntent().getExtras().getString("remuser");
             rempa = getIntent().getExtras().getString("rempass");
            dusername.setText(remus);
            dpass.setText(rempa);
            dremember.setChecked(true);
            dusername.setBackgroundColor(Color.rgb(255,255,0));
            dpass.setBackgroundColor(Color.rgb(255,255,0));
        }catch (Exception e){
            e.printStackTrace();
            dlog.setOnClickListener(this);
            dclr.setOnClickListener(this);
            dremember.setOnClickListener(this);

        }
      //  udb=openOrCreateDatabase()
        try {
            credentials = getApplicationContext().getSharedPreferences("cred", 0);
            String user = credentials.getString("name", "Unknown data");
            String secret = credentials.getString("password", "Unknown data");
            remstatus=credentials.getString("remstat","Unknown data");
            if (udb.userLogin(user,secret)!=0) {

                Intent allow = new Intent(getApplicationContext(), HomeDatabase.class);
                allow.putExtra("uname",user);
                startActivity(allow);
                finish();
            }
        }catch (Exception e){
            e.printStackTrace();

             dlog.setOnClickListener(this);
             dclr.setOnClickListener(this);
             dremember.setOnClickListener(this);
         //   udb.addCredential(new User("root","root"));
         //   udb.addCredential(new User("administrator","admin"));

        }
      //  udb.addCredential(new User("root","root"));
      //  udb.addCredential(new User("administrator","admin"));

        dlog.setOnClickListener(this);
        dclr.setOnClickListener(this);
        dremember.setOnClickListener(this);
        if(prefill==1){
            dusername.setText(remus);
            dpass.setText(rempa);
            dremember.setChecked(true);

        }

    }
    public void setReferences(){
        dusername =(EditText)findViewById(R.id.duser);
        dpass=(EditText)findViewById(R.id.dpwd);
        dlog=(Button)findViewById(R.id.denter);
        dclr=(Button)findViewById(R.id.dclear);
        daccess=(TextView)findViewById(R.id.dpermission);
        dremember=(CheckBox)findViewById(R.id.dremember);
    }
    @Override
    public void onClick(View v ) {
        Intent i;
        switch (v.getId()) {
            case R.id.denter:
                if (dusername.getText().toString().isEmpty() || dpass.getText().toString().isEmpty())
                { daccess.setText("Username or Password field is empty");
                    dusername.setText(""); dpass.setText("");}
                else if (udb.userLogin(dusername.getText().toString(), dpass.getText().toString())!=0){
                    Toast.makeText(getApplicationContext(),"welcome "+dusername.getText().toString(),Toast.LENGTH_SHORT).show();
                    i= new Intent(this,HomeDatabase.class);
                    i.putExtra("uname",dusername.getText().toString());
                    credentials = getApplicationContext().getSharedPreferences("cred", 0);
                    SharedPreferences.Editor edit = credentials.edit();
                    if(dremember.isChecked()){
                        edit.putString("check","1");
                        prefill=1;
                    }
                    else{edit.putString("check","2");}
                    edit.putString("name",dusername.getText().toString());
                    edit.putString("password",dpass.getText().toString());
                    edit.commit();
                    startActivity(i);
                    finish();

                }

                else if(udb.userLogin(dusername.getText().toString(),dpass.getText().toString())==0)
                    daccess.setText("something");
                else
                 daccess.setText("wrong");
                break;
            case R.id.dclear:
                daccess.setText("");
                dusername.setText("");
                dpass.setText("");
                break;
           /* case R.id.dremember:
                if (udb.userLogin(dusername.getText().toString(), dpass.getText().toString())!=0 && dremember.isChecked()){

                    String remu=getIntent().getExtras().getString("remuser");
                    String remp=getIntent().getExtras().getString("rempass");
                    dusername.setText(remu);
                    dpass.setText(remp);
                    daccess.setText("");

                }*/

        }
    }

}
