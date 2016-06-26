package com.example.saratchandra.summerinternapp;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by SaratChandra on 6/2/2016.
 */
public class ListViewTask extends AppCompatActivity {
    String [] names={"steve","John","sarath"};
    ArrayAdapter<String>adapter;
    ListView lvnames;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listviewtask);
        setTitle("ListViewTask");
        lvnames=(ListView)findViewById(R.id.names);
        adapter=new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,names){
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View view = super.getView(position, convertView, parent);
                TextView text = (TextView) view.findViewById(android.R.id.text1);
                text.setTextColor(Color.BLACK);
                return view;
            }
        };
        lvnames.setAdapter(adapter);
        lvnames.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String name=parent.getItemAtPosition(position).toString();
                Toast.makeText(getApplicationContext(),"Selected " +name,Toast.LENGTH_SHORT).show();
            }
        });

    }


}