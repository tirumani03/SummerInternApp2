package com.example.saratchandra.summerinternapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

/**
 * Created by SaratChandra on 5/30/2016.
 */
public class SpinnerTask extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    ArrayAdapter<String>adapter;
    Spinner spoptions;
    EditText edfir,edsec;
    TextView spresult;
    String options[] ={"select operation","Addition","Multiplication","Subtraction","Division"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.spinnertast);
        setTitle("SpinnerTask");
        spoptions=(Spinner)findViewById(R.id.spoption);
        edfir=(EditText)findViewById(R.id.edfir);
        edsec=(EditText)findViewById(R.id.edsec);
        spresult=(TextView)findViewById(R.id.answer);

        adapter=new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_spinner_item,options);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spoptions.setAdapter(adapter);
        spoptions.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Float a, b, c;
        String option = options[position];
        if (option == "select operation") {
            spresult.setText("select any operation");
        } else {
            a = Float.parseFloat(edfir.getText().toString());
            b = Float.parseFloat(edsec.getText().toString());
            switch (option) {
                case "Addition":
                    c = a + b;
                    spresult.setText(Float.toString(c));
                    break;
                case "Subtraction":
                    c = a - b;
                    spresult.setText(Float.toString(c));
                    break;
                case "select operation":
                    spresult.setText("select any one operation");
                    break;
                case "Multiplication":
                    c = a * b;
                    spresult.setText(Float.toString(c));
                    break;
                case "Division":
                    c = a / b;
                    spresult.setText(Float.toString(c));
                    break;

            }
        }
    }
    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
