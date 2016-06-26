package com.example.saratchandra.summerinternapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by SaratChandra on 5/25/2016.
 */
public class CalculateSI extends AppCompatActivity implements View.OnClickListener{
    EditText first,second,third;
    Button btnew;
    TextView res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculate_si);
        setTitle("Simple Interest");
        setReferences();
        // onClick(View v);
      //  first.setOnClickListener(this);
       // second.setOnClickListener(this);
       // third.setOnClickListener(this);
        btnew.setOnClickListener(this);
      //  res.setOnClickListener(this);
    }
    public void setReferences(){
        first =(EditText)findViewById(R.id.principle);
        second=(EditText)findViewById(R.id.roi);
        third=(EditText)findViewById(R.id.duration);
        btnew=(Button)findViewById(R.id.si);
        res=(TextView)findViewById(R.id.result);

    }
    public void onClick(View v ){
        float r,t,s;
        int p;
        if(first.getText().toString().isEmpty() || second.getText().toString().isEmpty() || third.getText().toString().isEmpty())
            res.setText("one or more fields are empty");
        else {

            p=Integer.parseInt(first.getText().toString());
            r=Float.parseFloat(second.getText().toString());
            t=Float.parseFloat(third.getText().toString());
                s=(p*r*t);
                res.setText(Float.toString(s));}

    }
}
