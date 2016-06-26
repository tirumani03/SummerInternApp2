package com.example.saratchandra.summerinternapp;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by SaratChandra on 5/29/2016.
 */
public class Myanimation extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.myanimation_activity);

        final ImageView iv=(ImageView)findViewById(R.id.imageView);
        final Animation an= AnimationUtils.loadAnimation(getBaseContext(),R.anim.rotate);
       final  Animation an2= AnimationUtils.loadAnimation(getBaseContext(),R.anim.abc_fade_out);
        iv.startAnimation(an);
        an.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                iv.startAnimation(an2);
                    finish();
                Intent i=new Intent(getBaseContext(),Login.class);
                startActivity(i);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        });


    }



}
