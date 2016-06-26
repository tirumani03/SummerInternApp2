package com.example.saratchandra.summerinternapp;

import android.content.ContentValues;

/**
 * Created by SaratChandra on 6/3/2016.
 */
public class User {
    int _Uid;
    String _username,_password;
    public User(){

    }
    public User(int id, String username, String password){
        this._Uid=id;
        this._username=username;
        this._password=password;
    }
    public User(String username, String password){
        this._username=username;
        this._password=password;
    }
    public int getId(){
        return this._Uid;
    }
    public void setName(){
        this._username=_username;
    }
    public String getUsersName(){
        return this._username;
    }
    public void setPassword(){
        this._password=_password;
    }
    public String getPassword(){
        return this._password;
    }
}
