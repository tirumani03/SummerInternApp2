package com.example.saratchandra.summerinternapp;

import android.app.Activity;
import android.app.ProgressDialog;
import android.net.wifi.WifiManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.text.format.Formatter;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.jar.Attributes;

/**
 * http://api.glassdoor.com/api/api.htm?v=1&format=json&t.p=72367&t.k=bCrGXVLe4Wq&action=employers&q=pharmaceuticals&userip=192.168.43.42&useragent=Mozilla/%2F4.0
 * Created by SaratChandra on 6/8/2016.
 */
/*http://it.ebooks
it hyper ebooksapi
click /sear/php
java file:jason parser-copy in package in
technology-php,
*/
public class JsonExample extends AppCompatActivity {
    JSONParser jparser= new JSONParser();
    private static final String AURL="http://10.0.2.2/android/insertuser.php";
    private static final String GURL="http://10.0.2.2/android/get.php";
    private static final String NURL="http://api.indeed.com/ads/apisearch";
    ProgressDialog pDialog;
    ArrayList<HashMap<String,String>>userslist;
    ArrayList<HashMap<String,String>>jobslist;
    ListView lv;
    HashMap<String, String> jobmap;
    JSONArray users=null;
    JSONArray jobs=null;
    String ip,userAgent;
    private static final String TAG_USERNAME="user";
    private static final String TAG_PASS="pass";
    private static final String TAG_SUCCESS="0";
    private static final String TAG_JID="id";
    private static final String TAG_JNAME="name";
    private static final String TAG_JWEBSITE="website";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginsql);
        setTitle("Login");
        lv=(ListView)findViewById(R.id.ulist);
        WifiManager wm = (WifiManager) getSystemService(WIFI_SERVICE);
         ip = Formatter.formatIpAddress(wm.getConnectionInfo().getIpAddress());
        Toast.makeText(getApplicationContext(),ip,Toast.LENGTH_SHORT).show();
         userAgent = System.getProperty("http.agent");
        Toast.makeText(getApplicationContext(),userAgent,Toast.LENGTH_SHORT).show();
       // new InsertUser().execute();
     //   lv=getListView();
       // new FetchUser().execute();
        new FetchJob().execute();
    }
    class InsertUser extends AsyncTask<Void,Void,Void>{

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
          pDialog=new ProgressDialog(JsonExample.this);
            pDialog.setTitle("Loading");
            pDialog.setCancelable(false);
            pDialog.show();
        }

        @Override
        protected Void doInBackground(Void... params) {

            List<NameValuePair> param = new ArrayList<NameValuePair>();
            param.add(new BasicNameValuePair("Username","kiran"));
            param.add(new BasicNameValuePair("Password","admin"));
            JSONObject jsonObject=jparser.makeHttpRequest(AURL,"GET",param);

            Log.d("Users",jsonObject.toString());


            try {
                int success = jsonObject.getInt("success");
                //if(success==1) Toast.makeText(getApplicationContext(),"added",Toast.LENGTH_SHORT).show();
            } catch (JSONException e) {
                e.printStackTrace();
                //Toast.makeText(getApplicationContext(),"not added",Toast.LENGTH_SHORT).show();
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            if(pDialog.isShowing()){
                pDialog.cancel();
            }
        }
    }
   class FetchUser extends AsyncTask<Void,Void,Void>{

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            userslist= new ArrayList<HashMap<String,String>>();
            pDialog=new ProgressDialog(JsonExample.this);
            pDialog.setTitle("Loading");
            pDialog.setCancelable(false);
            pDialog.show();
        }

        @Override
        protected Void doInBackground(Void... params) {
            List<NameValuePair> paramget = new ArrayList<NameValuePair>();
           // param.add(new BasicNameValuePair("Username","administrator"));
           // param.add(new BasicNameValuePair("Password","admin"));
            JSONObject jsonObject=jparser.makeHttpRequest(GURL,"POST",paramget);
            try {
               int success = jsonObject.getInt("success");
                if(success==1) {
                users=jsonObject.getJSONArray("users");
                    for(int i=0;i<users.length();i++){
                        JSONObject user=users.getJSONObject(i);
                        String username=user.getString("username");
                        String pass=user.getString("password");
                        HashMap<String,String> map=new HashMap<String, String>();
                        map.put(TAG_PASS,pass);
                        map.put(TAG_USERNAME,username);
                        userslist.add(map);
                    }
               }
            } catch (JSONException e) {
                e.printStackTrace();
     //           Toast.makeText(getApplicationContext(),"not added",Toast.LENGTH_SHORT).show();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
           super.onPostExecute(aVoid);
            if(pDialog.isShowing()){
                pDialog.cancel();
            }
            ListAdapter sadapter=new ArrayAdapter<>(JsonExample.this,android.R.layout.simple_list_item_1,userslist);
                  lv.setAdapter(sadapter);
        }

    }
    class FetchJob extends AsyncTask<Void,Void,Void>{

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            jobslist= new ArrayList<HashMap<String,String>>();
            pDialog=new ProgressDialog(JsonExample.this);
            pDialog.setTitle("Loading");
            pDialog.setCancelable(false);
            pDialog.show();
        }

        @Override
        protected Void doInBackground(Void... params) {
            List<NameValuePair> paramgetjob = new ArrayList<NameValuePair>();
             paramgetjob.add(new BasicNameValuePair("v","2"));
             paramgetjob.add(new BasicNameValuePair("format","json"));
            paramgetjob.add(new BasicNameValuePair("publisher","2048240434418677"));
            paramgetjob.add(new BasicNameValuePair("co","in"));
            paramgetjob.add(new BasicNameValuePair("l","Delhi"));
            paramgetjob.add(new BasicNameValuePair("q","java"));
            paramgetjob.add(new BasicNameValuePair("userip","192.168.43.42"));
            paramgetjob.add(new BasicNameValuePair("useragent","Mozilla/%2F4.0"));
            JSONObject jjobObject=jparser.makeHttpRequest(NURL,"GET",paramgetjob);
            try {

                    //Toast.makeText(getApplicationContext(),"success",Toast.LENGTH_SHORT).show();
                    jobs=jjobObject.getJSONArray("results");
                    for(int i=0;i<jobs.length();i++) {
                        JSONObject job = jobs.getJSONObject(i);
                        String jtitle = job.getString("jobtitle");
                        String jname = job.getString("company");
                        String jwebsite = job.getString("url");
                        HashMap<String, String> jobmap = new HashMap<String, String>();
                        jobmap.put(TAG_JID, jwebsite);
                        jobmap.put(TAG_JNAME, jname);
                        jobmap.put(TAG_JWEBSITE,jtitle);
                        jobslist.add(jobmap);

                }
               /* else{
                    HashMap<String, String> jobmap = new HashMap<String, String>();
                         jobmap.put(TAG_JID,"null");
                          jobslist.add(jobmap);
                }*/
            } catch (JSONException e) {
                e.printStackTrace();
                //           Toast.makeText(getApplicationContext(),"not added",Toast.LENGTH_SHORT).show();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            if(pDialog.isShowing()){
                pDialog.cancel();
            }
            /*jobmap.put(TAG_JWEBSITE,"null");
            jobslist.add(jobmap);
            */ListAdapter jadapter=new ArrayAdapter<>(JsonExample.this,android.R.layout.simple_list_item_1,jobslist);
            lv.setAdapter(jadapter);
        }

    }

}
