package com.example.saratchandra.summerinternapp;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

/**
 * Created by SaratChandra on 6/7/2016.
 */
public class ListViewDatabase extends Activity {
    ListView lvSQLite;
    DatabaseHandler db;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listviewdatabase);
        lvSQLite=(ListView)findViewById(R.id.lvdb);
        db=new DatabaseHandler(this);
      //  List<String> contactList=db.getAllNames();
      //  ArrayAdapter<String> adapter=new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,contactList);
       // lvSQLite.setAdapter(adapter);

    }

    }
