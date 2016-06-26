package com.example.saratchandra.summerinternapp;

import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SaratChandra on 6/7/2016.
 */
public class UsersDatabaseHandler extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION =1;
    public static final String DATABASE_NAME="UserCredentials";
    public static final String TABLE_NAME="Users";

    public static final String KEY_ID="Uid";    //rememeber that Id is created there not KEY_ID.
    public static final String KEY_USER_NAME="username";
    public static final String KEY_PASS_WORD="password";

        public UsersDatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String CREATE_TABLE="CREATE TABLE "+TABLE_NAME+"("+ KEY_ID+" INTEGER PRIMARY KEY, "+KEY_USER_NAME+" TEXT NOT NULL UNIQUE, "+KEY_PASS_WORD+" TEXT NOT NULL);";
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME+";");
        onCreate(db);
    }
    public void addCredential(User ud){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
       // values.put(KEY_ID,ud.getId());
        values.put(KEY_USER_NAME,ud.getUsersName());
        values.put(KEY_PASS_WORD,ud.getPassword());
        db.insert(TABLE_NAME,null,values);
        //db.close();
    }
    public void removeCredential(User ud){
        this.getWritableDatabase().delete(TABLE_NAME,KEY_USER_NAME+"='"+ud.getUsersName()+"'",null);
    }
    public void updateCredential(String old_name,String new_num){
        this.getWritableDatabase().execSQL("UPDATE "+TABLE_NAME+" SET "+KEY_PASS_WORD+"='"+new_num+"' WHERE "+KEY_USER_NAME+"='"+old_name+"'");
    }
    public void listCredential(TextView get){
        Cursor cur= this.getReadableDatabase().rawQuery("SELECT * FROM "+TABLE_NAME,null);
        get.setText("");
        while (cur.moveToNext()) {
            get.append(cur.getString(1)+" "+cur.getString(2)+"\n");
        }
    }
    public boolean fetchCredential(String u,String p){
        SQLiteDatabase db=this.getWritableDatabase();
        this.getReadableDatabase().execSQL("SELECT "+KEY_USER_NAME+","+KEY_PASS_WORD+" FROM "+TABLE_NAME+" WHERE "+KEY_USER_NAME+"='"+u+"'",null);
        if(KEY_PASS_WORD==p){
            return true;
        }
        else
            return false;
    }
    public int userLogin(String u,String p){
        SQLiteDatabase db=this.getWritableDatabase();
        String SELECT_USERS ="SELECT * FROM users WHERE username= '"+u+"' AND password='"+p+"'";
        Cursor cursor=db.rawQuery(SELECT_USERS,null);
        cursor.moveToFirst();
                int i=cursor.getCount();
        cursor.close();
                return i;
    }
    public void updateCred(User ud){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(KEY_USER_NAME,ud.getUsersName());
        values.put(KEY_PASS_WORD,ud.getPassword());
      //  db.update(TABLE_NAME,values,KEY_ID+);
    }
    public List<String>getAllNames(){
        SQLiteDatabase db=this.getWritableDatabase();
        String SELECT_CONTACTS ="SELECT * FROM "+TABLE_NAME;
        Cursor cur=db.rawQuery(SELECT_CONTACTS,null);
        List<String> contactList=new ArrayList<String>();
        if(cur.moveToNext()){
            do{
                contactList.add(cur.getString(1));

            }while(cur.moveToNext());
        }
        cur.close();
        return contactList;
    }
    public int getNumContacts(){
        SQLiteDatabase db=this.getWritableDatabase();
        String SELECT_USERS ="SELECT * FROM "+TABLE_NAME;
        Cursor cur = db.rawQuery(SELECT_USERS,null);
        return cur.getCount();
    }

}
