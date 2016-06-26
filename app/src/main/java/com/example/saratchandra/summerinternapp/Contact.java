package com.example.saratchandra.summerinternapp;

import android.content.ContentValues;

/**
 * Created by SaratChandra on 6/3/2016.
 */
public class Contact {
    int _id;
    String _name,_phone_number;
    public Contact(){

    }
    public Contact(int id,String name,String phone_number){
         this._id=id;
        this._name=name;
        this._phone_number=phone_number;
    }
    public Contact(String name,String phone_number){
        this._name=name;
        this._phone_number=phone_number;
    }
    public void setId(int id){
        this._id=id;
    }
    public int getId(){
        return this._id;
    }
    public void setName(){
        this._name=_name;
    }
    public String getName(){
        return this._name;
    }
    public void setPhoneNumber(){
        this._phone_number=_phone_number;
    }
    public String getPhoneNumber(){
        return this._phone_number;
    }
}
