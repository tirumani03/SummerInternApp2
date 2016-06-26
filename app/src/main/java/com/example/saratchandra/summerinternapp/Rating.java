package com.example.saratchandra.summerinternapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by SaratChandra on 6/1/2016.
 */
public class Rating extends AppCompatActivity {
    RatingBar rate;
    TextView verdict;
    Button upload;
    public int semaphore=0;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ratingbar);
        setTitle("rating");
        setReferences();
    }

    public void setReferences() {
        rate = (RatingBar) findViewById(R.id.ratingBar);
        verdict = (TextView) findViewById(R.id.verdict);
        upload=(Button)findViewById(R.id.upload);
        rate.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            public void onRatingChanged(RatingBar ratingBar, float rating,
                                        boolean fromUser) {
             if(rating>=0.5)
                verdict.setText(String.valueOf(rating));
                else
                 verdict.setText("Enter a minimum rating of 0.5");

            }
        });
       upload.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               semaphore=1;
               int token=0;
               verdict.setText("submitted");
               String s="";
               int st=(int)rate.getRating();
             switch (st){
                 case 0:
                     s="Enter minimum 0.5";
                     break;
                 case 1:
                     s="very bad";
                     break;
                 case 2: s="Bad";
                     break;
                 case 3:
                     s="Average";
                     break;
                 case 4:
                     s="good";
                     break;
                 case 5:
                     s="very good";
                     break;

             }

               if (semaphore == 1 && token==0) {
                   Toast t=Toast.makeText(Rating.this,s,Toast.LENGTH_SHORT);
                   t.show();
                   semaphore=0;token=1;
               }
               else if(token==1){
                   Toast t=Toast.makeText(Rating.this,s,Toast.LENGTH_SHORT);
                   t.cancel();

               }



           }
       });
    }
}
