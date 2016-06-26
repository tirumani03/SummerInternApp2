package com.example.saratchandra.summerinternapp;

import android.Manifest;
import android.content.ContentResolver;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by SaratChandra on 6/15/2016.
 */
public class ContentProviderExample extends AppCompatActivity {
    int MY_PERMISSIONS_REQUEST_READ_CONTACTS;
    TextView cont;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cpexample);
        cont=(TextView)findViewById(R.id.contp);
        createContacts();
    }
    public void createContacts(){
        StringBuffer sb=new StringBuffer();
        String p_no=null;
        ContentResolver cr=getContentResolver();
        sb.append("....contact Details....\n");
        Cursor curp=cr.query(ContactsContract.Contacts.CONTENT_URI,null,null,null,null);
        if(curp.getCount()>0){
            if(curp.moveToFirst()){
                do{
                    String Id=curp.getString(curp.getColumnIndex(ContactsContract.Contacts._ID));
                    String pname=curp.getString(curp.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));

                    Cursor pcur=cr.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,null,ContactsContract.CommonDataKinds.Phone.CONTACT_ID+"=?",new String[]{Id},null);
                     if(pcur.moveToFirst()){
                         do {
                             p_no = pcur.getString(pcur.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                         }while ((pcur.moveToNext()));
                     }
                    sb.append(("Id: "+Id+"Name :" +pname+"phone: "+p_no+"\n"));
                }while (curp.moveToNext());
            }
        }
        cont.setText(sb);
    }
}
