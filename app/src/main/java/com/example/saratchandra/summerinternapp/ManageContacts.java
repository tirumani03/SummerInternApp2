package com.example.saratchandra.summerinternapp;

import android.content.DialogInterface;
import android.database.sqlite.SQLiteConstraintException;
import android.database.sqlite.SQLiteDatatypeMismatchException;
import android.os.Bundle;
import android.preference.DialogPreference;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by SaratChandra on 6/3/2016.
 */
public class ManageContacts extends AppCompatActivity implements View.OnClickListener {
    DatabaseHandler db;
    Button add,rem,upd,listcontacts;
    TextView lis;
    EditText first_name,number;
//sqlite browser plugin to view files
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contacts);
         db=new DatabaseHandler(this);

        add=(Button)findViewById(R.id.add_contact);
        upd=(Button)findViewById(R.id.remove_contact);
        rem=(Button)findViewById(R.id.update_contact);
        listcontacts=(Button)findViewById(R.id.view_contacts);
        lis=(TextView)findViewById(R.id.lis);
       first_name=(EditText)findViewById(R.id.first_name);
        number=(EditText)findViewById(R.id.number);
        add.setOnClickListener(this);
        upd.setOnClickListener(this);
        rem.setOnClickListener(this);
        listcontacts.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.add_contact:
                try{
                    db.addContact(new Contact(first_name.getText().toString(),number.getText().toString()));
                }catch (Exception e){
                    e.printStackTrace();
                    Toast.makeText(getApplicationContext(),"Already exists",Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.remove_contact:
                try{
                    db.removeContact(new Contact(first_name.getText().toString(),null));
                }catch (Exception e){
                    Toast.makeText(this,"Doesn't exists",Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.update_contact:
                try{
                    AlertDialog.Builder dialog =new AlertDialog.Builder(ManageContacts.this);
                    dialog.setTitle("Enter New number");
                    final EditText new_number = new EditText(this);
                    dialog.setView(new_number);
                    dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            db.updateContact(first_name.getText().toString(),new_number.getText().toString());
                        }
                    });
                    dialog.show();
                }catch (Exception e){
                    Toast.makeText(getApplicationContext(),"Not found",Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.view_contacts:
                try{
                    db.listContacts(lis);
                }catch (Exception e){
                    Toast.makeText(getApplicationContext(),"No contacts to show",Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
}
