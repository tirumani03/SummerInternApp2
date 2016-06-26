package com.example.saratchandra.summerinternapp;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by SaratChandra on 6/2/2016.
 */
/*Task: Add Logout button in login if we close, second layout should open if credentials
are passed through shared preferences
*/
// using shared preferences
    //sustained even when the activity is closed. session management.
    //If we login put value in shared value.if present already login otherwise ask again.
public class SessionManagement extends AppCompatActivity{
    SharedPreferences pref;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sessionsharedpreferences);
        setTitle("session manager");
        pref = getApplicationContext().getSharedPreferences("Mypref", 0);// 0 means private value
        //if we doesn't commit it will not be saved in DBMS and in edit
        SharedPreferences.Editor edit = pref.edit();
        //edit.putString("unique","admin");
        edit.remove("uname");//removes only one value
        edit.clear();//all values are removed.Don't forget edit.commit() it's necessary for every edit functions
        edit.commit();
        Toast.makeText(getApplicationContext(),"Data passed",Toast.LENGTH_SHORT).show();
        //DBMS/fileexplorer/data/data/com.example.saratchandra.summerinternapp/shared_pref/Mypref.xml then pull to desktop

        /*String uname =pref.getString("uname","Unknown data");
        Toast.makeText(getApplicationContext(),uname,Toast.LENGTH_SHORT);*/

    }
}
