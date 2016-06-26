package com.example.saratchandra.summerinternapp;

import java.io.File;
import java.util.ArrayList;

import android.media.ThumbnailUtils;
import android.os.Bundle;
import android.os.Environment;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

public class Gallery extends AppCompatActivity {

    public class ImageAdapter extends BaseAdapter {

        private Context mContext;
        ArrayList<String> itemList = new ArrayList<String>();

        public ImageAdapter(Context c) {
            mContext = c;
        }

        void add(String path){
            itemList.add(path);
        }

        @Override
        public int getCount() {
            return itemList.size();
        }

        @Override
        public Object getItem(int arg0) {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public long getItemId(int position) {
            // TODO Auto-generated method stub
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView imageView;
            if (convertView == null) {  // if it's not recycled, initialize some attributes
                imageView = new ImageView(mContext);
                imageView.setLayoutParams(new GridView.LayoutParams(350, 350));
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                imageView.setPadding(1, 0, 0, 1);
            } else {
                imageView = (ImageView) convertView;
            }

            Bitmap bm = decodeSampledBitmapFromUri(itemList.get(position), 350, 350);

            imageView.setImageBitmap(bm);
            return imageView;
        }

        public Bitmap decodeSampledBitmapFromUri(String path, int reqWidth, int reqHeight) {

            Bitmap bm = null;
            // First decode with inJustDecodeBounds=true to check dimensions
            final BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(path, options);

            // Calculate inSampleSize
            options.inSampleSize = calculateInSampleSize(options, reqWidth, reqHeight);

            // Decode bitmap with inSampleSize set
            options.inJustDecodeBounds = false;
            bm = BitmapFactory.decodeFile(path, options);

            return bm;
        }

        public int calculateInSampleSize(

                BitmapFactory.Options options, int reqWidth, int reqHeight) {
            // Raw height and width of image
            final int height = options.outHeight;
            final int width = options.outWidth;
            int inSampleSize = 1;

            if (height > reqHeight || width > reqWidth) {
                if (width > height) {
                    inSampleSize = Math.round((float)height / (float)reqHeight);
                } else {
                    inSampleSize = Math.round((float)width / (float)reqWidth);
                }
            }

            return inSampleSize;
        }

    }

    ImageAdapter myImageAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewer);
        setTitle("Gallery");

        GridView gridview = (GridView) findViewById(R.id.gridview);
        myImageAdapter = new ImageAdapter(this);
        gridview.setAdapter(myImageAdapter);

        String targetPath = Environment
                .getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES)
                .getPath();
          String videopath =Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MOVIES).getPath();
          Bitmap thumb = ThumbnailUtils.createVideoThumbnail(videopath, MediaStore.Images.Thumbnails.MINI_KIND);
       // Toast.makeText(getApplicationContext(), targetPath, Toast.LENGTH_LONG).show();
        File targetDirector = new File(targetPath);
      //  File videoDirectory=new File(videopath);
        File[] files = targetDirector.listFiles();
        for (File file : files) {
            myImageAdapter.add(file.getAbsolutePath());
        }
       /* File[] videos = videoDirectory.listFiles();
        for (File file : videos){
            myImageAdapter.add(file.getAbsolutePath());
        }
    */
    }
}