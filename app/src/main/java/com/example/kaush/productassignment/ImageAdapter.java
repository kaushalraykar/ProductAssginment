package com.example.kaush.productassignment;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.ImageView;

public class ImageAdapter extends BaseAdapter {
    private int [] mArrayImage;
    private Context mContext;

    public ImageAdapter(int[] ArrayImage, Context Context) {
        this.mArrayImage = ArrayImage;
        this.mContext = Context;
    }

    @Override
    public int getCount() {
        return mArrayImage.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {
        ImageView imageView;
        if(convertView==null){
            Log.e("tag","position in new :"+i);
            imageView=new ImageView(mContext);
            imageView.setLayoutParams(new AbsListView.LayoutParams(300,300));
        }
        else{
            Log.e("tag","position in same :"+i);
            imageView= (ImageView) convertView;
        }
        imageView.setImageResource(mArrayImage[i]);
        return imageView;
    }
}
