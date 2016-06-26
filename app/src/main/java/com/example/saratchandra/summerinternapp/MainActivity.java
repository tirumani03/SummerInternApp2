package com.example.saratchandra.summerinternapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    EditText et1,et2;
    Button bt1,bt2,bt3,bt4,bt5;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Simple calculator");
        setReferences();
       // onClick(View v);
      //  et1.setOnClickListener(this);
        //et2.setOnClickListener(this);
       bt1.setOnClickListener(this);
        bt2.setOnClickListener(this);
        bt3.setOnClickListener(this);
        bt4.setOnClickListener(this);
        bt5.setOnClickListener(this);
        tv.setOnClickListener(this);
    }
    public void setReferences(){
        et1 =(EditText)findViewById(R.id.first);
        et2=(EditText)findViewById(R.id.second);
        bt1=(Button)findViewById(R.id.addition);
        bt2=(Button)findViewById(R.id.subtraction);
        bt3=(Button)findViewById(R.id.multiplication);
        bt4=(Button)findViewById(R.id.division);
        bt5=(Button)findViewById(R.id.modulus);
        tv=(TextView)findViewById(R.id.result);

    }
    public void onClick(View v ){
        float a,b,c;
        a=Float.parseFloat(et1.getText().toString());
        b=Float.parseFloat(et2.getText().toString());


        switch (v.getId()) {
            case R.id.addition :
            c = a + b;
            tv.setText(Float.toString(c));
                break;
            case R.id.subtraction :
                c=a-b;
                tv.setText(Float.toString(c));
                break;
            case R.id.multiplication :
                c=a*b;
                tv.setText(Float.toString(c));
                break;
            case R.id.division :
                c=a/b;
                tv.setText(Float.toString(c));
                break;
            case R.id.modulus :
                c=a%b;
                tv.setText(Float.toString(c));
                break;
        }
        }


}
