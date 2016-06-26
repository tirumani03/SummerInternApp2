package com.example.saratchandra.summerinternapp;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by SaratChandra on 6/7/2016.
 */
public class LoginTable extends Activity implements View.OnClickListener{
    UsersDatabaseHandler udb;
    Button goadd,goremove,goupdate,goview;
    EditText useruser,passpass;
    TextView gotv;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.logintable);
        setTitle("LoginTable");
        udb=new UsersDatabaseHandler(this);

        goadd=(Button)findViewById(R.id.goadd);
        goupdate=(Button)findViewById(R.id.goupdate);
        goremove=(Button)findViewById(R.id.goremove);
        goview=(Button)findViewById(R.id.goview);
        useruser=(EditText)findViewById(R.id.useruser);
        passpass=(EditText)findViewById(R.id.passpass);
        gotv=(TextView)findViewById(R.id.gotv);
        goadd.setOnClickListener(this);
        goupdate.setOnClickListener(this);
        goremove.setOnClickListener(this);
        goview.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.goadd:
                try{
                    udb.addCredential(new User(useruser.getText().toString(),passpass.getText().toString()));
                }catch (Exception e){
                    Toast.makeText(getApplicationContext(),"Already exists",Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.goremove:
                try{
                    udb.removeCredential(new User(useruser.getText().toString(),null));
                }catch (Exception e){
                    Toast.makeText(this,"Doesn't exists",Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.goupdate:
                try{
                    AlertDialog.Builder dialog =new AlertDialog.Builder(LoginTable.this);
                    dialog.setTitle("Enter new password");
                    final EditText new_pass = new EditText(this);
                    dialog.setView(new_pass);
                    dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            udb.updateCredential(useruser.getText().toString(),new_pass.getText().toString());
                        }
                    });
                    dialog.show();
                }catch (Exception e){
                    Toast.makeText(getApplicationContext(),"Not found",Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.goview:
                try{
                    udb.listCredential(gotv);
                }catch (Exception e){
                    Toast.makeText(getApplicationContext(),"No contacts to show",Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
}
