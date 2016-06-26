package com.example.saratchandra.summerinternapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;

/**
 * Created by SaratChandra on 6/16/2016.
 */
public class ImageAdapterClass extends BaseAdapter {
   private Context context;
    private static String[] mobilevalues;
    public ImageAdapterClass(Context context,String[] mobilevalues){
        this.context=context;
        this.mobilevalues=mobilevalues;
    }
    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater linflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View grid;
        if(convertView==null){
            grid=new View(context);
            grid=linflater.inflate(R.layout.mobile,null);
        }

        return null;
    }
}
