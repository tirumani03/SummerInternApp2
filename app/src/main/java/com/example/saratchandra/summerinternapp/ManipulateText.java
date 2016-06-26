package com.example.saratchandra.summerinternapp;

/**
 * Created by SaratChandra on 6/1/2016.
 */

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class ManipulateText extends AppCompatActivity implements View.OnClickListener{

    EditText ed1;
    TextView tv;
    Button bt1,bt2,bt3,bt4,bt5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.manipulate);
        setReferences();
        bt1.setOnClickListener(this);
        bt2.setOnClickListener(this);
        bt3.setOnClickListener(this);
        bt4.setOnClickListener(this);
        bt5.setOnClickListener(this);

    }

    private void setReferences() {
        bt1=(Button)findViewById(R.id.upp);
        bt2=(Button)findViewById(R.id.lw);
        bt3=(Button)findViewById(R.id.fcy);
        bt4=(Button)findViewById(R.id.uf);
        bt5=(Button)findViewById(R.id.uw);
        ed1=(EditText)findViewById(R.id.ed);
        tv=(TextView)findViewById(R.id.result);
    }


    @Override
    public void onClick(View v) {
        String str=ed1.getText().toString().trim();

        switch(v.getId()){
            case R.id.upp :
                tv.setText(str.toUpperCase());
                break;
            case R.id.lw :
                tv.setText(str.toLowerCase());
                break;
            case R.id.fcy :

                char c[] =new char[str.length()];
                for(int j=0;j<str.length();j++) {
                    if (j % 2 == 0)
                        c[j] = str.toUpperCase().charAt(j);
                    else
                        c[j] = str.toLowerCase().charAt(j);

                }
                tv.setText(c.toString());
                break;
            case R.id.uf :

                str=ed1.getText().toString();
                str=str.toUpperCase().charAt(0)+str.substring(1).toLowerCase();
                tv.setText(str);
                break;
            case R.id.uw :

                str=str.toUpperCase().charAt(0)+str.substring(1);
                for(int i=0;i<str.length();i++){
                    if(str.charAt(i)==' '){
                        str=str.substring(0,i+1)+str.toUpperCase().charAt(i+1)+str.substring(i+2).toLowerCase();
                    }
                }
                tv.setText(str);
                break;

        }

    }
}
