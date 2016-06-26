package com.example.saratchandra.summerinternapp;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.TextView;

/**
 * Created by SaratChandra on 6/14/2016.
 */
public class GridViewExample extends AppCompatActivity {

    GridView grimage;
    String[] alpha={"A","B","C","D"};
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gridview_example);
        setTitle("gridview");
        grimage = (GridView) findViewById(R.id.gridimage);
        ArrayAdapter<String> imadapter= new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_gallery_item,alpha){
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View view = super.getView(position, convertView, parent);
                TextView text = (TextView) view.findViewById(android.R.id.text1);
                text.setTextColor(Color.BLACK);
                return view;
            }
        };
        grimage.setAdapter(imadapter);
    }

    }
