package com.example.saratchandra.summerinternapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.nfc.NfcAdapter;
import android.widget.TextView;

/**
 * Created by SaratChandra on 6/3/2016.
 */
/*users table id-primary key,username password both text;check login credentials from this users table.Remember me-if credentials are correct
    checkbosx selected and login.after logout the values in edittext should be fixed.*/
   // UI cannot be created in runtime.we can just make it visible or gone using java code.
public class DatabaseHandler extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION =1;
    public static final String DATABASE_NAME="contactManger";
    public static final String TABLE_NAME="contacts";

    public static final String KEY_ID="Id";    //rememeber that Id is created there not KEY_ID.
    public static final String KEY_NAME="name";
    public static final String KEY_PHONE_NUMBER="phone_number";

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        //remaining values should be fixed so name,factory,version in the parameters are removed

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        /*code when the database is created for the first time.This is where the creation of tables and the initial population of the
        tables should happen*/
        String CREATE_TABLE="CREATE TABLE "+TABLE_NAME+"("+ KEY_ID+" INTEGER PRIMARY KEY, "+KEY_NAME+" TEXT NOT NULL UNIQUE, "+KEY_PHONE_NUMBER+" TEXT NOT NULL UNIQUE);";

     db.execSQL(CREATE_TABLE);//execute which is not "select" or anyother which data is return
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            /*code when the database needs to be upgraded.The implementation should use this method to draw tables,add tables
              or do anything else it needs to upgrade to the new schema version. (alter)*/
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME+";");
        onCreate(db);
    }
    public void addContact(Contact cn){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(KEY_NAME,cn.getName());
     //   values.put(KEY_ID,cn.getId());
        values.put(KEY_PHONE_NUMBER,cn.getPhoneNumber());
        db.insert(TABLE_NAME,null,values);
        //db.close();
    }
    public void removeContact(Contact cn){
        this.getWritableDatabase().delete(TABLE_NAME,KEY_NAME+"='"+cn.getName()+"'",null);
    }
    public void updateContact(String old_name,String new_num){
     this.getWritableDatabase().execSQL("UPDATE "+TABLE_NAME+" SET "+KEY_PHONE_NUMBER+"='"+new_num+"' WHERE "+KEY_NAME+"='"+old_name+"'");
    }
    public void listContacts(TextView get){
        Cursor cur= this.getReadableDatabase().rawQuery("SELECT * FROM "+TABLE_NAME,null);
        get.setText("");
        while (cur.moveToNext()) {
            get.append(cur.getString(1)+" "+cur.getString(2)+"\n");
        }
    }
}
