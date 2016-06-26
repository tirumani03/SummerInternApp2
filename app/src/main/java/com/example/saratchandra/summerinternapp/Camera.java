package com.example.saratchandra.summerinternapp;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.RelativeLayout;
import android.widget.VideoView;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by SaratChandra on 6/1/2016.
 */

public class Camera extends AppCompatActivity {
    ImageView imv;
    VideoView viv;
    Button capture;
    Button capturevideo;
    Button gly;
    Bitmap img;
    MediaController mc;
    DisplayMetrics dm = new DisplayMetrics();
    ContentValues values;
    String mCurrentPhotoPath;
    String mCurrentVideoPath;
    static final int REQUEST_TAKE_PHOTO = 1;
    static final int REQUEST_TAKE_VIDEO = 10;
    Intent takeVideoIntent;

    private void dispatchTakeVideoIntent() {
        takeVideoIntent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
        if (takeVideoIntent.resolveActivity(getPackageManager()) != null) {
            File videoFile = null;
            try {
                videoFile = createVideoFile();
            } catch (IOException ex) {
                capture.setText("file not created");
            }
            if (videoFile != null) {
                takeVideoIntent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(videoFile));
                capture.setText("almost done");
                startActivityForResult(takeVideoIntent, REQUEST_TAKE_VIDEO);
            }
        }

    }

    @Override
    public void onBackPressed() {
        if(capture.isShown())
        super.onBackPressed();
        else{
            capture.setVisibility(View.VISIBLE);
            capturevideo.setVisibility(View.VISIBLE);
            imv.setVisibility(View.GONE);
            viv.setVisibility(View.GONE);

        }
    }

    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        // Ensure that there's a camera activity to handle the intent
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {

            // Create the File where the photo should go
            File photoFile = null;
            try {
                photoFile = createImageFile();
            } catch (IOException ex) {
                // Error occurred while creating the File
                capture.setText("file not created");
            }
            // Continue only if the File was successfully created
            if (photoFile != null) {
                takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT,
                        Uri.fromFile(photoFile));
                capture.setText("almost");
                startActivityForResult(takePictureIntent, REQUEST_TAKE_PHOTO);
            }
        }

    }

    private File createVideoFile() throws IOException {
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String videoFileName = "MP4_" + timeStamp + "_";
        File storageDir = Environment.getExternalStoragePublicDirectory(
                Environment.DIRECTORY_MOVIES);
        File video = File.createTempFile(
                videoFileName,  /* prefix */
                ".mp4",         /* suffix */
                storageDir      /* directory */
        );
        storageDir.mkdirs();

        // Save a file: path for use with ACTION_VIEW intents
        mCurrentVideoPath = video.getAbsolutePath();
        return video;
    }

    private File createImageFile() throws IOException {
        // Create an image file name
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String imageFileName = "JPEG_" + timeStamp + "_";
        File storageDir = Environment.getExternalStoragePublicDirectory(
                Environment.DIRECTORY_PICTURES);
        File image = File.createTempFile(
                imageFileName,  /* prefix */
                ".jpg",         /* suffix */
                storageDir      /* directory */
        );
        storageDir.mkdirs();

        // Save a file: path for use with ACTION_VIEW intents
        mCurrentPhotoPath = image.getAbsolutePath();
        return image;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.captureimage);
        setTitle("camera");
        imv = (ImageView) findViewById(R.id.imageView2);
        viv = (VideoView) findViewById(R.id.videoview);
        capture = (Button) findViewById(R.id.Go);
        capturevideo = (Button) findViewById(R.id.takevideo);
        gly=(Button)findViewById(R.id.gallery);
        gly.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

              Intent gal=new Intent(getApplicationContext(),Gallery.class);
                startActivity(gal);
            }
        });

        capture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dispatchTakePictureIntent();

            }
        });
        capturevideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dispatchTakeVideoIntent();
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_TAKE_PHOTO && resultCode == RESULT_OK) {
            imv.setVisibility(View.VISIBLE);
            capture.setVisibility(View.GONE);
            capturevideo.setVisibility(View.GONE);
            viv.setVisibility(View.GONE);
            imv.setImageDrawable(Drawable.createFromPath(mCurrentPhotoPath));
            capture.setText("continue");
        }
     else if (requestCode == REQUEST_TAKE_VIDEO && resultCode==RESULT_OK) {
            viv.setVisibility(View.VISIBLE);
            capturevideo.setVisibility(View.GONE);
            capture.setVisibility(View.GONE);
            mc = new MediaController(this);
            dm = new DisplayMetrics();
            this.getWindowManager().getDefaultDisplay().getMetrics(dm);
            int height = dm.heightPixels;
            int width = dm.widthPixels;
            android.widget.FrameLayout.LayoutParams params = (android.widget.FrameLayout.LayoutParams) viv.getLayoutParams();
            params.width =  dm.widthPixels;
            params.height = dm.heightPixels;
            params.leftMargin = 0;
            viv.setLayoutParams(params);
            viv.setMinimumWidth(width);
             viv.setMinimumHeight(height);
            viv.setMediaController(mc);
            viv.setVideoPath(mCurrentVideoPath);
            viv.start();
          /*  Intent intent = new Intent(Intent.ACTION_VIEW );
            intent.setDataAndType(Uri.parse(mCurrentVideoPath), "video/*");
            startActivity(intent);*/

        }

    }

}