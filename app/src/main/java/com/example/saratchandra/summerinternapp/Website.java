package com.example.saratchandra.summerinternapp;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.io.File;

/**
 * Created by SaratChandra on 6/3/2016.
 */
public class Website extends AppCompatActivity implements View.OnClickListener {
    WebView web;
     GestureDetector gs=null;
    Button google,gmail,chrome,youtube,fb;
    ProgressBar bar;
    private boolean haveNetworkConnection() {
        boolean haveConnectedWifi = false;
        boolean haveConnectedMobile = false;


        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo[] netInfo = cm.getAllNetworkInfo();
        for (NetworkInfo ni : netInfo) {
            if (ni.getTypeName().equalsIgnoreCase("WIFI"))
                if (ni.isConnected())
                    haveConnectedWifi = true;
            if (ni.getTypeName().equalsIgnoreCase("MOBILE"))
                if (ni.isConnected())
                    haveConnectedMobile = true;
        }
        return haveConnectedWifi || haveConnectedMobile;
    }
    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting();
    }
    public String CheckNet() {
        String html=null;
        if (!haveNetworkConnection()) {
            // File f= new File(Environment.getExternalStorageDirectory(),"MyFolder");
            //String filename ="image.png";
            // String imagePath = "file://"+ f.getAbsolutePath() + File.separator + filename;
            String imagePath = "mipmap://" + R.mipmap.boss;
            html = "<html><head></head><body><Marquee><img src=\"" + imagePath + "\">My Scroll Text</Marquee></body></html>";

            // web.loadDataWithBaseURL("", html, "text/html", "utf-8", "");
        }
        return html;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.website);
       // getWindow().requestFeature(Window.FEATURE_PROGRESS);
        web=(WebView)findViewById(R.id.web);
        String code=CheckNet();
        web.getSettings().setBuiltInZoomControls(true);
        if(!haveNetworkConnection()&& code!=null){
        web.loadDataWithBaseURL("", code, "text/html", "utf-8", "");}
        else
            web.loadUrl("http://www.google.com");
        WebSettings ws=web.getSettings();
        ws.setJavaScriptEnabled(true);
        bar =(ProgressBar)findViewById(R.id.bar);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            bar.setProgressTintList(ColorStateList.valueOf(Color.rgb(65,105,225)));
        }
        //bar.setProgress(20);
      //final ProgressDialog  dialogbar = ProgressDialog.show(Website.this, "Showing ProgressDialog", "Loading...");

        //  web.loadUrl("http://www.google.com");
        web.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                bar.setVisibility(View.VISIBLE);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                bar.setVisibility(View.GONE);
            }

        });
        web.setWebChromeClient(new WebChromeClient(){

            @Override
            public void onProgressChanged(WebView view, int newProgress) {
               // super.onProgressChanged(view, newProgress);
                bar.setProgress(newProgress);
            }
        });
        web.setScrollBarStyle(WebView.SCROLLBARS_OUTSIDE_OVERLAY);
        google=(Button)findViewById(R.id.google);
        gmail=(Button)findViewById(R.id.gm);

        youtube=(Button)findViewById(R.id.ytb);
        fb=(Button)findViewById(R.id.fac);
        google.setOnClickListener(this);
        gmail.setOnClickListener(this);
        youtube.setOnClickListener(this);
        fb.setOnClickListener(this);


    }

    @Override
    public void onBackPressed() {

        if(web.canGoBack()){
            web.goBack();
        }
        else {
            super.onBackPressed();
        }
    }

    @Override
    public void onClick(View v) {
        String code=CheckNet();
        if(!haveNetworkConnection()&& code!=null){
            web.loadDataWithBaseURL("", code, "text/html", "utf-8", "");}
        else
        {

        switch (v.getId()) {
            case R.id.google:
                web.loadUrl("http://www.google.com");
                break;
            case R.id.fac:
                web.loadUrl("http://www.fb.com");
                break;
            case R.id.ytb:
                web.loadUrl("http://www.youtube.com");
                break;
            case R.id.gm:
                web.loadUrl("http://www.gmail.com");
                break;
        }
        }
    }
}
