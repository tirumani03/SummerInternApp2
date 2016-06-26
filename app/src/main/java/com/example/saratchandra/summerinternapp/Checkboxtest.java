package com.example.saratchandra.summerinternapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by SaratChandra on 5/26/2016.
 */
public class Checkboxtest extends AppCompatActivity implements View.OnClickListener {
    CheckBox cb1,cb2,cb3;
    TextView tvres;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check);
        setTitle("checkboxtest");
        setReferences();
        cb1.setOnClickListener(this);
        cb2.setOnClickListener(this);
        cb3.setOnClickListener(this);

    }
    public void setReferences(){
        cb1=(CheckBox)findViewById(R.id.ch1);
        cb2=(CheckBox)findViewById(R.id.ch2);
        cb3=(CheckBox)findViewById(R.id.ch3);
        tvres=(TextView)findViewById(R.id.techresult);

    }
    @Override
    public void onClick(View v) {
        tvres.setText("you have selected");

                 if(cb1.isChecked())
                     tvres.append(" Android");
                 else if(cb2.isChecked())
                     tvres.append(" ios");
                 else if(cb3.isChecked())
                     tvres.append(" windows");

    }
}
